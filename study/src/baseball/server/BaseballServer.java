package baseball.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 무한 대기하고 socket 넘겨서 쓰레드 작동.
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
		while (true) {// 계속 대기
			System.out.println("접속 대기");
			socket = serverSocket.accept(); // 접속 대기.
			System.out.println("-접속-.");
			// 접속자 socket을 매개변수로 쓰레드 객체 생성 후 start()
			BaseballServerThread st = new BaseballServerThread(socket);
			Thread t1 = new Thread(st);
			t1.start();
		}// while(true) end
	}//playGame
}
