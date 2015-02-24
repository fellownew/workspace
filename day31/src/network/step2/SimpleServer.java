package network.step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import network.util.NetworkUtil;

//������ Ŭ���̾�Ʈ�� �����ϸ� Ŭ���̾�Ʈ�κ��� ���ڿ��� �޾Ƽ� ���.
public class SimpleServer {
	ServerSocket serverSocket = null;
	Socket socket = null;
	BufferedReader br = null; // Ŭ���̾�Ʈ�κ��� ���� ���ڿ�

	public static void main(String[] args) {
		SimpleServer ss = new SimpleServer();
		ss.receiveString();
	}

	public void receiveString() {
		// �������� ����
		try {
			serverSocket = new ServerSocket(5000);
		} catch (IOException e) {
			// 5000�� ��Ʈ�� ������ϰ�� �浹�� ���� ���� �߻�.
			e.printStackTrace();
			return;
		}// �������� ���� ����
		while (true) {
			try {
				System.out.println("-----Client�� ������ ��ٸ��ϴ�.-----");
				// Ŭ���̾�Ʈ ������ ��ٸ��� ����Ǹ� socket�� ����.
				socket = serverSocket.accept();
				br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // ���ڿ� ����
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
		}// while ����
	}// recieveString ����
}// Ŭ���� ����