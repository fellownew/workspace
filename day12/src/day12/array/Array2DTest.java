package day12.array;

public class Array2DTest {
	public static void main(String[] args) {
		Array2DTest at = new Array2DTest();
		at.basicTest2();
	}

	public void basicTest1() {
		// 2차원배열 생성
		int arr[][] = new int[3][2];
		arr[0][0] = 10;
		arr[0][1] = 20;
		arr[1][0] = 30;
		arr[1][1] = 40;
		arr[2][0] = 50;
		arr[2][1] = 60;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println(arr[i][j]);
			}
		}
	}

	public void basicTest2() {
		boolean bArr[][] = { { false, true, true }, { true, true },
				{ false, false, false, true } };
		int count = 0;
		for (boolean[] i : bArr) {
			System.out.println("---" + count + "---");
			count++;
			for (boolean j : i) {
				System.out.println(j);
			}
		}
		// for(int i=0;i<bArr.length;i++){
		// for(int j=0;j<bArr[i].length;j++){
		// System.out.println(bArr[i][j]);
		// }
		// }
	}

	public void basicTest3() {
		double[][] dArr = new double[3][];
		dArr[0] = new double[2];
		dArr[1] = new double[5];
		dArr[2] = new double[4];
		int count = 0;
		for (double[] i : dArr) {
			System.out.println("---" + count + "---");
			count++;
			for (double j : i) {
				System.out.println(j);
			}
		}
	}
}
