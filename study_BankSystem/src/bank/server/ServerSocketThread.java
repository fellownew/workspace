package bank.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ���� ���� ���� accept�� ������
 * ������ �����Ͽ� ���μ��������� ���� ������ 9000���� ����
 */
public class ServerSocketThread implements Runnable {
	private ServerSocket serverSocket;
	private Socket socket;

	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(9000);
		} catch (IOException e) {
			e.printStackTrace();
		}//serverSocket 
		
		while (true) {
			try {
				System.out.println("���� ���");
				socket = serverSocket.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
			new Thread(new ServerProcessThread(socket)).start();
		}//accept�� ���� while end
	}//run end
}//class end
