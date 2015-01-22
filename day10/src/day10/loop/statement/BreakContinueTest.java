package day10.loop.statement;

public class BreakContinueTest {
	public static void main(String[] args) {
		boolean flag = true;
		int sum = 1;
		int count = 1;
		// ���ؼ� 3�� ������ ����
		while (flag) {
			sum += sum;
			System.out.println(sum);
			if (sum > 300000)
				break;
		}
		// 3662�� ���° �����ΰ�
		while (flag) {
			int num = (int) (Math.random() * 10000);
			System.out.println(count++ + " : " + num);
			if (num == 3662)
				break;
		}
		// �� ã�� �� �߰��� ���߱�
		for (int i = 1; i < 100; i++) {
			if (i == 26) {
				System.out.println(i);
				break;
			}
		}
		// Ư�� ���� ����
		// Ư�� �����϶� �ݺ������� �����Ű�� ����.
		for (int i = 1; i < 10; i++) {
			if (i == 5)
				continue;
			System.out.println(i);
		}
		// while�������� ������ ��ġ�� �� �����ؾ���.
		int j = 10;
		while (j > 0) {
			j--;
			if (j == 5)
				continue;
			System.out.println(j);
		}
		// 5�� ����� ���
		int k = 0;
		while (k <= 1000) {
			k++;
			if (k % 5 != 0) {
				continue;
			}
			System.out.println(k);
		}
		// label ����
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