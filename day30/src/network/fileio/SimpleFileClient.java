package network.fileio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SimpleFileClient {
	//서버로부터 파일을 받아서 컴퓨터에 저장(출력)함.
	//Input : server 
	//FileOutputStream ( C:\\JAVA\\save\\lighthouse.jpg )
	public static void main(String[] args) throws IOException{
		//클라이언트단 연결과정
		//1. Socket을 생성(ip:String, port:int)
		Socket socket = null;
		InputStream is = null;
		FileOutputStream fos = null;
		try{
			socket = new Socket("localhost",5000);
			//2. Socket에서 In/OutputStream 조회
			is = socket.getInputStream();
			fos = new FileOutputStream("C:\\JAVA\\temp\\copy_image.jpg");
			//3. I/O 작업
			byte[] buffer = new byte[1000];
			int length = is.read(buffer);
			while(length!=-1){
				fos.write(buffer,0,length);
				length = is.read(buffer);
			}
		}finally{
			if(fos!=null){
				fos.close();
			}
			if(is!=null){
				is.close();
			}
			if(socket!=null){
				socket.close();
			}
		}
	}
}//클래스 종료
