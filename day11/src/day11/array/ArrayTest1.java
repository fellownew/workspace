package day11.array;

public class ArrayTest1 {
	public static void main(String[] args) {
		// ���� Ŭ���� ���� �޼ҵ忩�� ����ϱ� ���ؼ� staticó���ϰų� ��ü�� �����Ͽ� ����
		ArrayTest1 at = new ArrayTest1();
		// at.arrayBasic2();
//		int[] intArr = new int[3];
//		at.arrayBasic3(intArr);
		//���� ���� �ٷ� �Ű����� �ֱ�
		at.arrayBasic3(new int[]{52,6,3,424,63,52});
		at.arrayBasic4();
	}

	public void arrayBasic() {
		// length 5�� �迭 ����� �� index�� �� �ʱ�ȭ
		// 1. �迭Ÿ�� ���� ����
		// int jumsu2[]; int[] jumsu3;
		// 2. �迭��ü ����
		// jumsu2 = new int[5]; jumsu3=new int[5];
		int[] jumsu = new int[5];
		// 3. �� index �� �ʱ�ȭ (�� ����)
		// jumsu2[0]=23;
		for (int i = 0; i < jumsu.length; i++) {
			jumsu[i] = (int) (Math.random() * 101);
			System.out.println(jumsu[i]);
		}
	}

	public void arrayBasic2() {
		long[] larr = new long[3];
		System.out.println("larr �迭�� ũ�� : " + larr.length);
		larr[1] = 300;
		System.out.println(larr[2]);
		boolean bArr[] = new boolean[2];
		System.out.println(bArr[0]);
		double[] dArr = new double[4];
		System.out.println(dArr[0]);
	}

	public void arrayBasic3(int[] arr) {
		// �Ű������� ���� �迭 ��ü���� ��ü index�� ���
		for (int idx = 0; idx < arr.length; idx++) {
			System.out.println(arr[idx]);
		}
	}

	public void arrayBasic4() {
		double[] dArr = { 10.5, 235.3, 234.9, 32.7, 63.4, 342.4, 3423.6,
				234.21, 453.4 };
		for(int i =0;i<dArr.length;i++){
			System.out.println(dArr[i]);
		}
		String[] name ={"��","��","��","��","��"};
		for(int i =0;i<name.length;i++){
			System.out.println(name[i]);
		}
	}
	public void arrayBasic5(){
		boolean[] b;
		b = new boolean[] {true,true,true,false};
		System.out.println(b);
		
	}
}