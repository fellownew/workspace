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
		while (true) {//���� ��� ��.
			System.out.println("New Game");
			win = false;
			ranNum = createRandomNum();

			while (!win) {
				System.out.println("1~9 ������ ���� 3���� �Է����ּ���");
				rNumber = br.readLine();
				while (rNumber.length() != 3) {
					System.out.println("���� 3���� �Է����ּ���");
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
		
			for(int i = 0;i<3;i++){//����ȭ
				checkNumber[i]=receivenumber[i]-48;
			}
			
			for(int i = 0;i<3;i++){//���� Ȯ��
				if(checkNumber[i]<=0||10<checkNumber[i]){
					System.out.println("1~9�� ���ڸ� �־��ּ���");
					return zeroNumber;
				}
			}
		
			if(checkNumber[0]==checkNumber[1]||checkNumber[1]==checkNumber[2]||checkNumber[0]==checkNumber[2]){//���� ���� Ȯ��
				System.out.println("�������ڴ� ���� ������");
				return zeroNumber;
			}
		
		return checkNumber; //�� if���� �Ȱɸ��� ����.
	}//checkNumber end

	public boolean compareNumber(int[] ranNum, int[] userNumber) {
		int strike = 0;
		int ball = 0;
		if(userNumber[0]==0){//zeroNumber�� �Ѿ���� ���� ���� ����.
			return false;
		}
		
		for (int i = 0; i < 3; i++) { //���� �� �� strike, ball ����
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
			System.out.println("�̰���ϴ�.");
			return true;
		}
		System.out.println(strike + "��Ʈ����ũ" + ball + "��");
		return false;
	}
}