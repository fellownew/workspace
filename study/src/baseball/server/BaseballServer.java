package baseball.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ���� ����ϰ� socket �Ѱܼ� ������ �۵�.
 *
 */
public class BaseballServer {
	ServerSocket serverSocket;
	Socket socket;
	public static void main(String[] args) throws IOException {
		BaseballServer baseball = new BaseballServer();
		baseball.playGame();
	}
	
	public void playGame() throws IOException{
		try {
			serverSocket = new ServerSocket(13678); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		while (true) {// ��� ���
			System.out.println("���� ���");
			socket = serverSocket.accept(); // ���� ���.
			System.out.println("-����-.");
			// ������ socket�� �Ű������� ������ ��ü ���� �� start()
			BaseballServerThread st = new BaseballServerThread(socket);
			Thread t1 = new Thread(st);
			t1.start();
		}// while(true) end
	}//playGame
}
