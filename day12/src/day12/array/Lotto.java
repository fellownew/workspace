package day12.array;

import java.util.Random;

public class Lotto {
	// 로또 번호 6개 선정 , 1~45.
	public static void main(String[] args) {
		Lotto lt = new Lotto();
		int lot[];
		lot = lt.createLottoNumber();
		for (int i = 0; i < lot.length; i++) {
			System.out.print(lot[i] + " ");
		}
	}

	public int[] createLottoNumber() {
		Random ran = new Random();
		int[] totalNumber = new int[45];
		int[] number = new int[6];
		int rannum = 0;
		// 1~45 대입
		for (int i = 0; i < totalNumber.length; i++) {
			totalNumber[i] = i + 1;
		}

		for (int i = 0; i < 6; i++) {
			if (totalNumber[i] < 0) {
				i--;
				continue;
			} else {
				rannum = ran.nextInt(45);
				number[i] = totalNumber[rannum];
				totalNumber[rannum] = -1;
			}
		}
		return number;
	}
}
