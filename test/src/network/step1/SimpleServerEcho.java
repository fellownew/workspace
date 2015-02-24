package network.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import network.util.NetworkUtil;

public class SimpleServerEcho {
	ServerSocket serverSocket = null;
	Socket socket = null;
	BufferedReader br = null;
	PrintWriter pw = null;

	public static void main(String[] args) {
		SimpleServerEcho sse = new SimpleServerEcho();
		sse.serverEcho();
	}

	public void serverEcho() {
		int count = 0;
		String[] str= new String[100];
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
				br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 문자열 리더
				str[count] = br.readLine();
				while (str[count] != null) {
					System.out.println(str[count]);
					str[count] = br.readLine();
					count++;
				}
				System.out.println("정상적으로 전송받았습니다.");
				
					pw =  new PrintWriter(socket.getOutputStream());
					for(int i =0;i<str.length;i++){
						pw.println(str[i]);
						pw.flush();
					}
					
			System.out.println("전송 완료");
			
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
	}//serverEcho 종료
}//class종료
