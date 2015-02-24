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
				System.out.println("-----Client�� ������ ��ٸ��ϴ�.-----");
				// Ŭ���̾�Ʈ ������ ��ٸ��� ����Ǹ� socket�� ����.
				socket = serverSocket.accept();
				System.out.println("Client ����");
				br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // ���ڿ� ����
				pw =  new PrintWriter(socket.getOutputStream(),true);
				String str = br.readLine();
				while (str != null) {
					pw.println("���� : "+str);
					str = br.readLine();
				}	
				System.out.println("���� ����");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					NetworkUtil.close(br, pw, socket);//�Է¿� ���� ���� ����
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}// while ����
	}
}
