package thread.sleep;

public class SimpleTimer implements Runnable {
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { //sleep ���ε� ����� ����
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
