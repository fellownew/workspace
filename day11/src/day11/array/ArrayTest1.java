package day11.array;

public class ArrayTest1 {
	public static void main(String[] args) {
		// 같은 클래스 내의 메소드여도 사용하기 위해선 static처리하거나 객체를 생성하여 실행
		ArrayTest1 at = new ArrayTest1();
		// at.arrayBasic2();
//		int[] intArr = new int[3];
//		at.arrayBasic3(intArr);
		//선언 없이 바로 매개변수 주기
		at.arrayBasic3(new int[]{52,6,3,424,63,52});
		at.arrayBasic4();
	}

	public void arrayBasic() {
		// length 5개 배열 만들고 각 index에 값 초기화
		// 1. 배열타입 변수 선언
		// int jumsu2[]; int[] jumsu3;
		// 2. 배열객체 생성
		// jumsu2 = new int[5]; jumsu3=new int[5];
		int[] jumsu = new int[5];
		// 3. 각 index 값 초기화 (값 대입)
		// jumsu2[0]=23;
		for (int i = 0; i < jumsu.length; i++) {
			jumsu[i] = (int) (Math.random() * 101);
			System.out.println(jumsu[i]);
		}
	}

	public void arrayBasic2() {
		long[] larr = new long[3];
		System.out.println("larr 배열의 크기 : " + larr.length);
		larr[1] = 300;
		System.out.println(larr[2]);
		boolean bArr[] = new boolean[2];
		System.out.println(bArr[0]);
		double[] dArr = new double[4];
		System.out.println(dArr[0]);
	}

	public void arrayBasic3(int[] arr) {
		// 매개변수로 받은 배열 객체내의 전체 index값 출력
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
		String[] name ={"가","나","다","라","마"};
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