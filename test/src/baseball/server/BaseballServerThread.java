package baseball.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class BaseballServerThread implements Runnable {
	Socket socket;
	PrintWriter pw = null;
	public BaseballServerThread(Socket socket) {
		this.socket=socket;
		// TODO Auto-generated constructor stub
		try {
			pw = new PrintWriter(this.socket.getOutputStream(),true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		BufferedReader br = null;
		String name=null;
		String rNumber=null;
		boolean win;
		int[] ranNum = new int[3];
		int count,rCount=1;
		
		try{
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw.println("이름을 입력하세요");
			name = br.readLine();
			while (true) {//게임 계속 함.
				
				
				pw.println(rCount+"Round Game start"); //시작을 알림
				count = 0;
				win = false;
				ranNum = createRandomNum();
	
				while (!win) {
					pw.println("1~9 사이의 숫자 3개를 입력해주세요");
					rNumber = br.readLine();
					win = compareNumber(ranNum, checkNumber(rNumber));
					count++;
				}// win while end
				pw.println("시도 횟수 : "+count);
				rCount++;
				Rank.addRank(new User(count,name));
			}// while end
		}catch(Exception e){
			e.getStackTrace();
		}finally{
			if(pw!=null){
				pw.close();
				}
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(socket!=null){
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		Rank.saveRank();
	}

	
	public int[] createRandomNum(){
		int[] ranNum = new int[3];
		Random random = new Random();
		for (int idx = 0; idx < ranNum.length; idx++) {
			ranNum[idx] = random.nextInt(9)+1;
			for (int idx2 = 0; idx2 < idx; idx2++) {
				if (ranNum[idx] == ranNum[idx2]) {
					ranNum[idx] = random.nextInt(9)+1;
					idx2--;
				}
			}
		}
		return ranNum;
	}//createRandomNum end
	
	public int[] checkNumber(String rNumber) throws IOException {
		int[] checkNumber=new int[3];
		int[] zeroNumber = {0,0,0};
		char[] receivenumber = rNumber.toCharArray();
		
			for(int i = 0;i<3;i++){//숫자화
				checkNumber[i]=receivenumber[i]-48;
			}
			
			for(int i = 0;i<3;i++){//범위 확인
				if(checkNumber[i]<=0||10<checkNumber[i]){
					pw.println("숫자만");
					return zeroNumber;
				}
			}
		
			if(checkNumber[0]==checkNumber[1]||checkNumber[1]==checkNumber[2]||checkNumber[0]==checkNumber[2]){//같은 숫자 확인
				pw.println("같은숫자 안됩니다.");
				return zeroNumber;
			}
			if (rNumber.length() != 3) {
				pw.println("숫자 3개만 입력해주세요");
				return zeroNumber;
			}
		
		return checkNumber; //위 if문에 안걸리면 리턴.
	}//checkNumber end

	public boolean compareNumber(int[] ranNum, int[] userNumber) throws IOException {
		int strike = 0;
		int ball = 0;
		if(userNumber[0]==0){//zeroNumber가 넘어오면 구문 실행 안함.
			return false;
		}
		
		for (int i = 0; i < 3; i++) { //숫자 비교 후 strike, ball 지정
			for (int j = 0; j < 3; j++) {
				if (ranNum[i] == userNumber[j]) {
					ball++;
				}
				if(ranNum[i]==userNumber[j]&&i==j){
					ball--;
					strike++;
				}
			}
		}
		
		if (strike == 3) {
			pw.println("승리");
			return true;
		}
		pw.println(strike + "스트라이크" + ball + "볼");
		return false;
	}
}