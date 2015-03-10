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
			pw.println("�̸��� �Է��ϼ���");
			name = br.readLine();
			while (true) {//���� ��� ��.
				
				
				pw.println(rCount+"Round Game start"); //������ �˸�
				count = 0;
				win = false;
				ranNum = createRandomNum();
	
				while (!win) {
					pw.println("1~9 ������ ���� 3���� �Է����ּ���");
					rNumber = br.readLine();
					win = compareNumber(ranNum, checkNumber(rNumber));
					count++;
				}// win while end
				pw.println("�õ� Ƚ�� : "+count);
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
		
			for(int i = 0;i<3;i++){//����ȭ
				checkNumber[i]=receivenumber[i]-48;
			}
			
			for(int i = 0;i<3;i++){//���� Ȯ��
				if(checkNumber[i]<=0||10<checkNumber[i]){
					pw.println("���ڸ�");
					return zeroNumber;
				}
			}
		
			if(checkNumber[0]==checkNumber[1]||checkNumber[1]==checkNumber[2]||checkNumber[0]==checkNumber[2]){//���� ���� Ȯ��
				pw.println("�������� �ȵ˴ϴ�.");
				return zeroNumber;
			}
			if (rNumber.length() != 3) {
				pw.println("���� 3���� �Է����ּ���");
				return zeroNumber;
			}
		
		return checkNumber; //�� if���� �Ȱɸ��� ����.
	}//checkNumber end

	public boolean compareNumber(int[] ranNum, int[] userNumber) throws IOException {
		int strike = 0;
		int ball = 0;
		if(userNumber[0]==0){//zeroNumber�� �Ѿ���� ���� ���� ����.
			return false;
		}
		
		for (int i = 0; i < 3; i++) { //���� �� �� strike, ball ����
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
			pw.println("�¸�");
			return true;
		}
		pw.println(strike + "��Ʈ����ũ" + ball + "��");
		return false;
	}
}