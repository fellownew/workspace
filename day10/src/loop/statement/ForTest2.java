package loop.statement;

public class ForTest2 {
	public static void main(String[] args) {
		// System.out.print(); �Ű������� ���� �� �״�� ���
		// System.out.println(); �Ű������� ���� �� ��� �� \n ����

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}

		// 2~19 ������
		for (int i = 2; i < 20; i++) {
			System.out.println("----" + i + "��----");
			for (int j = 1; j < 10; j++) {
				System.out.println(i + " x " + j + " = " + (i * j));
			}
		}

		for (int i = 1; i < 6; i++) {
			for (int j = 5; j > i; j--) {
				System.out.print(" ");
			}
			for (int k = 0; k < i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int k = 5; k > i; k--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}