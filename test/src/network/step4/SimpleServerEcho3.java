package network.step4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class SimpleServerEcho3 {
	ServerSocket serverSocket = null;
	Socket socket = null;
	ArrayList<Socket> member;


	public static void main(String[] args) throws IOException {
		SimpleServerEcho3 sse = new SimpleServerEcho3();
		sse.serverEcho();
	}

	public void serverEcho() throws IOException {
		try {
			serverSocket = new ServerSocket(5000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		while (true) {

				System.out.println("-----Client의 접속을 기다립니다.-----");
				// 클라이언트 연결을 기다리다 연결되면 socket을 리턴.
				socket = serverSocket.accept();
				member.add(socket);
				System.out.println("Client 접속");
				
				ServerThread serverThread = new ServerThread(socket,member);
				Thread t = new Thread(serverThread);
				t.start();

		}// while 종료
	}
}
