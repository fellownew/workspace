package thread.sleep.filemove;

import java.io.File;

//C:\\JAVA\\dir1�� �ִ� ������ C:\\JAVA\\dir2�� �̵���Ű�� thread
//5�ʿ� 1���� �ű�
public class FileMoveThread implements Runnable {
	File dir = new File("C:\\JAVA\\dir1");
	File file = null;
	String[] str = null;
	boolean flag;
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		str = dir.list();
		for(int i = 1;i<str.length;i++){
			file = new File(dir,str[0]);
			flag = file.renameTo(new File("C:\\JAVA\\dir2","newFile"+i));
			System.out.println(str[0]+" �̵� : "+flag);
			System.out.println(str.length);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			str = dir.list();
		}
	}
}