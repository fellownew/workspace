package baseball.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class BaseballServer {

	public static void main(String[] args) throws IOException {
		BaseballServer bb = new BaseballServer();
		bb.playGame();
	}

	public void playGame() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String rNumber=null;
		boolean win;
		int[] ranNum = new int[3];
		while (true) {//게임 계속 함.
			System.out.println("New Game");
			win = false;
			ranNum = createRandomNum();

			while (!win) {
				System.out.println("1~9 사이의 숫자 3개를 입력해주세요");
				rNumber = br.readLine();
				while (rNumber.length() != 3) {
					System.out.println("숫자 3개만 입력해주세요");
					rNumber = br.readLine();
				}
				win = compareNumber(ranNum, checkNumber(rNumber));

			}// win while end
		}// while end
	}// playGame end
	
	public int[] createRandomNum(){
		int[] ranNum = new int[3];
		Random random = new Random();
		for (int idx = 0; idx < ranNum.length; idx++) {
			ranNum[idx] = random.nextInt(9)+1;
			for (int idx2 = 0; idx < idx; idx2++) {
				if (ranNum[idx] == ranNum[idx2]) {
					ranNum[idx] = random.nextInt(9)+1;
					idx2 = -1;
					System.out.println(ranNum[0]);
				}
			}
		}
		return ranNum;
	}//createRandomNum end
	
	public int[] checkNumber(String rNumber) {
		int[] checkNumber=new int[3];
		int[] zeroNumber = {0,0,0};
		char[] receivenumber = rNumber.toCharArray();
		
			for(int i = 0;i<3;i++){//숫자화
				checkNumber[i]=receivenumber[i]-48;
			}
			
			for(int i = 0;i<3;i++){//범위 확인
				if(checkNumber[i]<=0||10<checkNumber[i]){
					System.out.println("1~9의 숫자만 넣어주세요");
					return zeroNumber;
				}
			}
		
			if(checkNumber[0]==checkNumber[1]||checkNumber[1]==checkNumber[2]||checkNumber[0]==checkNumber[2]){//같은 숫자 확인
				System.out.println("같은숫자는 넣지 마세요");
				return zeroNumber;
			}
		
		return checkNumber; //위 if문에 안걸리면 리턴.
	}//checkNumber end

	public boolean compareNumber(int[] ranNum, int[] userNumber) {
		int strike = 0;
		int ball = 0;
		if(userNumber[0]==0){//zeroNumber가 넘어오면 구문 실행 안함.
			return false;
		}
		
		for (int i = 0; i < 3; i++) { //숫자 비교 후 strike, ball 지정
			for (int j = 0; j < 3; j++) {
				if (ranNum[i] == userNumber[j]&& i!=j) {
					ball++;
				}
				if(ranNum[i]==userNumber[j]&&i==j){
					strike++;
				}
			}
		}
		
		if (strike == 3) {
			System.out.println("이겼습니다.");
			return true;
		}
		System.out.println(strike + "스트라이크" + ball + "볼");
		return false;
	}
}