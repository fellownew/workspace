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
				System.out.println("-----Client�� ������ ��ٸ��ϴ�.-----");
				// Ŭ���̾�Ʈ ������ ��ٸ��� ����Ǹ� socket�� ����.
				socket = serverSocket.accept();
				br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // ���ڿ� ����
				str[count] = br.readLine();
				while (str[count] != null) {
					System.out.println(str[count]);
					str[count] = br.readLine();
					count++;
				}
				System.out.println("���������� ���۹޾ҽ��ϴ�.");
				
					pw =  new PrintWriter(socket.getOutputStream());
					for(int i =0;i<str.length;i++){
						pw.println(str[i]);
						pw.flush();
					}
					
			System.out.println("���� �Ϸ�");
			
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
	}//serverEcho ����
}//class����
