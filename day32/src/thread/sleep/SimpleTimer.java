package thread.sleep;

public class SimpleTimer implements Runnable {
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { //sleep 중인데 깨우면 예외
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
