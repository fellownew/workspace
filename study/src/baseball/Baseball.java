package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Baseball {

	public static void main(String[] args) throws IOException {
		Baseball bb = new Baseball();
		bb.playGame();
	}

	public void playGame() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Random random = new Random();
		String rNumber;
		boolean win;
		int[] ranNum = new int[3];
		int[] userNum = new int[3];
		while (true) {
			System.out.println("New Game");
			win = false;
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

			while (!win) {
				System.out.println("1~9 사이의 숫자 3개를 입력해주세요");
				rNumber = br.readLine();
				while (rNumber.length() != 3) {
					System.out.println("숫자 3개만 입력해주세요");
					rNumber = br.readLine();
				}
				userNum = checkNumber(rNumber);
				win = compareNumber(ranNum, userNum);

			}// win while end
		}// while end
	}// playGame end

	public int[] checkNumber(String rNumber) {
		try {
		int parseNum = Integer.parseInt(rNumber);
	} catch (Exception e) {
		e.getStackTrace();
	}
		int[] checkedNumber = new int[3];
		char[] receivenumber = rNumber.toCharArray();
		for(int i = 0;i<3;i++){
			if(checkedNumber[i] == receivenumber[i]-48){
				for(int j = 0;j<3;j++){
					checkedNumber[i]=0;
					}
				System.out.println("ㅏㅏ");
				return checkedNumber;
			}

			checkedNumber[i] = receivenumber[i]-48;
		}
		return checkedNumber;

	}

	public boolean compareNumber(int[] ranNum, int[] userNumber) {
		int strike = 0;
		int ball = 0;
		for (int i = 0; i < 3; i++) {
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
			System.out.println("아웃입니다.");
			return true;
		}
		System.out.println(strike + "스트라이크" + ball + "볼");
		return false;
	}
}