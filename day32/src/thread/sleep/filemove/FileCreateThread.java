package thread.sleep.filemove;

import java.io.File;
import java.io.IOException;

//C:\\JAVA\dir1�� 30�ʰ� 1�ʿ� 1���� ���� ����.
//newFile��ȣ
public class FileCreateThread implements Runnable{
	File file = null;
	boolean flag; 
	public void run(){
		for(int i =1;i<=30;i++){
			file = new File("C:\\JAVA\\dir1","newFile"+i);
			try {
				flag = file.createNewFile();
				System.out.println("newFile"+i+" ���� : "+flag);
				Thread.sleep(1000);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
