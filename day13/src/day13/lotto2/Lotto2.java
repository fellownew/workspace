package day13.lotto2;

public class Lotto2 {
	public static void main(String[] args) {
		int[] num = lotNum();
		for (int i = 0; i < 6; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println("");
		num = createLottoNumber();
		sort(num);
		for (int i = 0; i < 6; i++) {
			System.out.print(num[i] + " ");
		}
	}

	public static int[] createLottoNumber() {
		int[] lottoNum = new int[6];
		for (int idx = 0; idx < lottoNum.length; idx++) {
			lottoNum[idx] = (int) (Math.random() * 45) + 1;
			for (int idx2 = 0; idx < idx; idx2++) {
				if (lottoNum[idx] == lottoNum[idx2]) {
					lottoNum[idx] = (int) (Math.random() * 45 + 1);
					idx2 = -1;
				}
			}
		}
		return lottoNum;
	}

	public static int[] shuffle(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int ran = (int) (Math.random() * 45);
			int temp = arr[i];
			arr[i] = arr[ran];
			arr[ran] = temp;
		}
		return arr;
	}

	public static int[] lotNum() {
		int[] loNum = new int[45];
		for (int i = 0; i < loNum.length; i++) {
			loNum[i] = i + 1;
		}
		loNum = shuffle(loNum);
		return loNum;
	}

	public static void sort(int[] num) {
		int temp;
		for (int i = 0; i < num.length - 1; i++) {
			if (num[i] > num[i + 1]) {
				temp = num[i];
				num[i] = num[i + 1];
				num[i + 1] = temp;
				i = 0;
			}
		}
	}

}
