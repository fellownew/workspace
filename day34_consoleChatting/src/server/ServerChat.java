package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * ���� ���� ����Ǵ� main �޼ҵ�� socket accept��⸦ ���� �۾��� �ǽ�
 * ServerSocket���� ��Ʈ�� ����
 * accept ���� ������ serverThread�� �Ѱ���
 * ���� ����ؼ� ���� accept ���. �� �ݺ�.
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
				System.out.println("Client ���� �����...");
				// Ŭ���̾�Ʈ ������ ��ٸ��� ����Ǹ� socket�� ����.
				socket = serverSocket.accept();
				//������� ���� Thread ȣ��
				ServerThread st = new ServerThread(socket);
				SocketList.addList(st); //
				Thread t = new Thread(st);
				t.start();
				
				//Thread ȣ�� �� main thread�� ��� ���� ���
		}// while ����
	}
}