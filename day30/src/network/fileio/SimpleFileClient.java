package network.fileio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SimpleFileClient {
	//�����κ��� ������ �޾Ƽ� ��ǻ�Ϳ� ����(���)��.
	//Input : server 
	//FileOutputStream ( C:\\JAVA\\save\\lighthouse.jpg )
	public static void main(String[] args) throws IOException{
		//Ŭ���̾�Ʈ�� �������
		//1. Socket�� ����(ip:String, port:int)
		Socket socket = null;
		InputStream is = null;
		FileOutputStream fos = null;
		try{
			socket = new Socket("localhost",5000);
			//2. Socket���� In/OutputStream ��ȸ
			is = socket.getInputStream();
			fos = new FileOutputStream("C:\\JAVA\\temp\\copy_image.jpg");
			//3. I/O �۾�
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
}//Ŭ���� ����
