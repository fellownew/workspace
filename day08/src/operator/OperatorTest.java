package operator;

public class OperatorTest {
	public static void main(String[] args) {
		// 사칙연산 +,-,/,%,*
		System.out.println("5+3 = " + (5 + 3));
		System.out.println("5/2 = " + (5 / 2));
		System.out.println("5.0/2.0 = " + (5.0 / 2.0));
		System.out.println("5%3 = " + (5 % 2));

		//
		int a = 10;
		a++;
		System.out.println("a++ : " + a);
		a--;
		System.out.println("a-- : " + a);
		System.out.println("a++:" + a++);
		System.out.println("a:" + a);

		int x = 10;
		int y = --x;
		System.out.println("x=10,y=--x : " + x + "  " + y);

		int k = 10;
		int l = k--;
		System.out.println("k=10,l=k-- : " + k + "  " + l);

		// 비교연산

		int num = (int) (Math.random() * 101); // 0~1사이 double값 랜덤 산출. *101.

		System.out.println("num : " + num);
		System.out.println("num<50? : " + (num < 50));

		boolean flag = 20 <= num && num <= 50;
		System.out.println("20<=num<=50 ? : " + flag);
		flag = 20 > num || num > 50;
		System.out.println("num<20 or 50<num? : " + flag);

		System.out.println((num == 30) + " - " + (num != 30));
		System.out.println(!(num == 30) + " - " + !(num != 30));

		// 삼항 연산
		String str = num <= 50 ? "평균이하" : "평균이상";
		System.out.println(str);
	}
}
