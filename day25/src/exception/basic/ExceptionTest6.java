package exception.basic;

public class ExceptionTest6 {
	public static void main(String[] args) {
		ExceptionTest6 et6 = new ExceptionTest6();
		et6.worker1();
		et6.worker2("�ȳ�");
	}

	public void worker1() {
		System.out.println("worker1() ����");
		try {
			for (int i = 1; i < 10; i++) {
				Thread.sleep(100);
				System.out.println(i);
			}

		} catch (InterruptedException e) {
			System.err.println("sleep() ������ ���� �߻�");
			e.printStackTrace();
		}
		System.out.println("worker1() ����");
	}

	public void worker2(String str) {
		System.out.println("worker2() ����");
		int num = 0;
		try {
			num = Integer.parseInt(str);
		} catch (NumberFormatException ne) {
		}
		System.out.println(num + 20);
		System.out.println("worker2() ����");
	}
}
