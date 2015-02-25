package thread.sleep.filemove;

public class MainThread {
	public static void main(String[] args) {
		new Thread(new FileCreateThread()).start();
		new Thread(new FileMoveThread()).start();
	}
}