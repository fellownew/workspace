package bank.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 소켓 공장 무한 accept용 쓰레드
 * 소켓을 생성하여 프로세스쓰레드 실행 소켓은 9000으로 실행
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
				System.out.println("접속 대기");
				socket = serverSocket.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
			new Thread(new ServerProcessThread(socket)).start();
		}//accept를 위한 while end
	}//run end
}//class end
