package thread.sleep.filemove;

import java.io.File;

//C:\\JAVA\\dir1에 있는 파일을 C:\\JAVA\\dir2로 이동시키는 thread
//5초에 1개씩 옮김
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
			System.out.println(str[0]+" 이동 : "+flag);
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