package thread.sleep.filemove;

import java.io.File;
import java.text.DecimalFormat;

//C:\\JAVA\\dir1에 있는 파일을 C:\\JAVA\\dir2로 이동시키는 thread
//5초에 1개씩 옮김
public class FileMoveThread implements Runnable {
	File dir = new File("C:\\JAVA\\dir1");
	File file = null;
	String[] str = null;
	boolean flag;
	DecimalFormat df = new DecimalFormat("00");
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		str = dir.list();
		while(str.length!=0){
				file = new File(dir,str[0]);//원본 파일
	//			file = new File(dir,"newFile"+df.format(i));
				flag = file.renameTo(new File("C:\\JAVA\\dir2",str[0])); // 파일 이동 후 성공 여부 리턴
				System.out.println(str[0]+" 이동 : "+flag); //
	//			System.out.println("newFile"+i+"이동 완료");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				str = dir.list();
			}//while end
		}//run end
	}//class end
