package network.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import network.util.NetworkUtil;

public class SimpleServerEcho2 {
	ServerSocket serverSocket = null;
	Socket socket = null;
	BufferedReader br = null;
	PrintWriter pw = null;

	public static void main(String[] args) {
		SimpleServerEcho2 sse = new SimpleServerEcho2();
		sse.serverEcho();

	}

	public void serverEcho() {
		try {
			serverSocket = new ServerSocket(5000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		while (true) {
			try {
				System.out.println("-----Client의 접속을 기다립니다.-----");
				// 클라이언트 연결을 기다리다 연결되면 socket을 리턴.
				socket = serverSocket.accept();
				System.out.println("Client 접속");
				br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 문자열 리더
				pw =  new PrintWriter(socket.getOutputStream(),true);
				String str = br.readLine();
				while (str != null) {
					pw.println("내용 : "+str);
					str = br.readLine();
				}	
				System.out.println("접속 종료");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					NetworkUtil.close(br, pw, socket);//입력에 대한 소켓 닫음
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}// while 종료
	}
}
