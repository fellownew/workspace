package thread.sleep;

public class SleepTest {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new SimpleTimer());
		t.start();
		Thread.sleep(1000);
		t.interrupt();//block»óÅÂ ÀÖ´Â ³à¼®À» ±ú¿ò.
	}
}