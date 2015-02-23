package network.fileio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleFileServer {
	//������ �о Ŭ���̾�Ʈ���� ������.
	//FileInputStream ( C:\\JAVA\\lighthouse.jpg )
	//Output : Client 
	public static void main(String[] args) {
		//������ �������
		// 1. ServerSocket ����
		// Ŭ���̾�Ʈ�� �����ϸ� Socket�� �������ִ� ����.
		ServerSocket serverSocket = null;
		Socket socket = null;
		OutputStream os = null; //Ŭ���̾�Ʈ���� �����ֱ����� output
		FileInputStream fis = null; //�� ��ǻ�Ϳ� �ִ� ������ �б����� input
		try {
			serverSocket = new ServerSocket(5000);
		} catch (IOException e) {
			// 5000�� ��Ʈ�� ������ϰ�� �浹�� ���� ���� �߻�.
			e.printStackTrace();
			return;
		}

		// 2. Ŭ���̾�Ʈ�� ��û ���
		while(true){
			try {
				System.out.println("-----Client�� ������ ��ٸ��ϴ�.-----");
				socket = serverSocket.accept(); // Ŭ���̾�Ʈ ������ ��ٸ��� ����Ǹ� socket�� ����.
				System.out.println("-----Client�� �����߽��ϴ�.-----");
				// 3. Socket���κ��� In/OutputStream ��ȸ
				os = socket.getOutputStream();
				fis = new FileInputStream("C:\\JAVA\\Lighthouse.jpg");
				// 4. I/O �۾�
				byte[] buffer = new byte[10000];
				int length = fis.read(buffer); //��ǻ�Ϳ� �ִ� ������ ����.
				while(length!=-1){
					os.write(buffer,0,length);//��Ʈ��ũ�� ����
					length = fis.read(buffer);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				//fis �ݱ�
				if (fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				//os �ݱ�
				if (os != null) {
					try {
						os.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				//socket�ݱ�
				if (socket != null) {
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}//while
	}//main end
}//class end
