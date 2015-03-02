package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 가장 먼저 실행되는 main 메소드로 socket accept대기를 위한 작업을 실시
 * ServerSocket으로 포트를 열고
 * accept 받은 소켓을 serverThread로 넘겨줌
 * 이후 계속해서 소켓 accept 대기. 및 반복.
 */
public class ServerChat {
	ServerSocket serverSocket = null;
	Socket socket = null;

	public static void main(String[] args) throws IOException {
		ServerChat sse = new ServerChat();
		sse.chatSystem();
	}

	public void chatSystem() throws IOException {
		try {
			serverSocket = new ServerSocket(5000);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		while (true) {
				System.out.println("Client 접속 대기중...");
				// 클라이언트 연결을 기다리다 연결되면 socket을 리턴.
				socket = serverSocket.accept();
				//입출력을 위한 Thread 호출
				ServerThread st = new ServerThread(socket);
				SocketList.addList(st); //
				Thread t = new Thread(st);
				t.start();
				
				//Thread 호출 후 main thread는 계속 접속 대기
		}// while 종료
	}
}