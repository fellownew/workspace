package thread.sleep.filemove;

import java.io.File;
import java.io.IOException;

//C:\\JAVA\dir1에 30초간 1초에 1개의 파일 생성.
//newFile번호
public class FileCreateThread implements Runnable{
	File file = null;
	boolean flag; 
	public void run(){
		for(int i =1;i<=30;i++){
			file = new File("C:\\JAVA\\dir1","newFile"+i);
			try {
				flag = file.createNewFile();
				System.out.println("newFile"+i+" 생성 : "+flag);
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
