package day10.loop.statement;

public class BreakContinueTest {
	public static void main(String[] args) {
		boolean flag = true;
		int sum = 1;
		int count = 1;
		// 더해서 3만 넘으면 정지
		while (flag) {
			sum += sum;
			System.out.println(sum);
			if (sum > 300000)
				break;
		}
		// 3662는 몇번째 난수인가
		while (flag) {
			int num = (int) (Math.random() * 10000);
			System.out.println(count++ + " : " + num);
			if (num == 3662)
				break;
		}
		// 값 찾은 후 중간에 멈추기
		for (int i = 1; i < 100; i++) {
			if (i == 26) {
				System.out.println(i);
				break;
			}
		}
		// 특정 수만 배제
		// 특정 조건일때 반복구문을 실행시키지 않음.
		for (int i = 1; i < 10; i++) {
			if (i == 5)
				continue;
			System.out.println(i);
		}
		// while문에서는 증감식 위치를 잘 생각해야함.
		int j = 10;
		while (j > 0) {
			j--;
			if (j == 5)
				continue;
			System.out.println(j);
		}
		// 5의 배수만 출력
		int k = 0;
		while (k <= 1000) {
			k++;
			if (k % 5 != 0) {
				continue;
			}
			System.out.println(k);
		}
		// label 사용법
		test: for (int a = 0; a < 50; a++) {
				System.out.println("");
			for (int b = 50; a < b; b--) {
				System.out.print(a + " : " + b+"   ");
				if ((a + b) == 80) {
					break test;
				}
			}
		}
	}
}