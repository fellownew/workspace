package thread.sleep.filemove;

import java.io.File;

public class MainThread {
	public static void main(String[] args) {
		File dir = new File("C:\\JAVA\\dir1");
		File dir2 = new File("C:\\JAVA\\dir2");
		if(!dir.exists())dir.mkdirs();
		if(!dir2.exists())dir2.mkdirs();
		new Thread(new FileCreateThread()).start();
		new Thread(new FileMoveThread()).start();
	}
}