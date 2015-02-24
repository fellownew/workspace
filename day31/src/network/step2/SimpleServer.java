package network.step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import network.util.NetworkUtil;

//서버에 클라이언트가 접속하면 클라이언트로부터 문자열을 받아서 출력.
public class SimpleServer {
	ServerSocket serverSocket = null;
	Socket socket = null;
	BufferedReader br = null; // 클라이언트로부터 받을 문자열

	public static void main(String[] args) {
		SimpleServer ss = new SimpleServer();
		ss.receiveString();
	}

	public void receiveString() {
		// 서버소켓 생성
		try {
			serverSocket = new ServerSocket(5000);
		} catch (IOException e) {
			// 5000번 포트가 사용중일경우 충돌로 인해 예외 발생.
			e.printStackTrace();
			return;
		}// 서버소켓 구문 종료
		while (true) {
			try {
				System.out.println("-----Client의 접속을 기다립니다.-----");
				// 클라이언트 연결을 기다리다 연결되면 socket을 리턴.
				socket = serverSocket.accept();
				br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 문자열 리더
				String str = br.readLine();
				while (str != null) {
					System.out.println(str);
					str = br.readLine();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
				try {
					NetworkUtil.close(br, null, socket);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}// while 종료
	}// recieveString 종료
}// 클래스 종료