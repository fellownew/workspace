package bank.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import bank.util.NetworkUtil;

/**
 * �����κ��� ������ �޾� ����ڿ��� ǥ��I/O(�����)�� ���� ���
 *
 */
public class ClientThread implements Runnable {
	Socket socket = null;

	public ClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		BufferedReader receive = null;
		boolean flag = true;
		try {
			receive = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str = receive.readLine();
			while (flag) {
				System.out.println(str);
				str = receive.readLine();
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				NetworkUtil.close(receive, null, socket);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}