package network.step4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * ���� ���� ����Ǵ� main �޼ҵ�� socket accept��⸦ ���� �۾��� �ǽ�
 * ServerSocket���� ��Ʈ�� ����
 * accept ���� ������ serverThread�� �Ѱ���
 * ���� ����ؼ� ���� accept ���. �� �ݺ�.
 */
public class SimpleServerEcho3 {
	ServerSocket serverSocket = null;
	Socket socket = null;


	public static void main(String[] args) throws IOException {
		SimpleServerEcho3 sse = new SimpleServerEcho3();
		sse.serverEcho();
	}

	public void serverEcho() throws IOException {
		try {
			serverSocket = new ServerSocket(5000);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		while (true) {

				System.out.println("-----Client�� ������ ��ٸ��ϴ�.-----");
				// Ŭ���̾�Ʈ ������ ��ٸ��� ����Ǹ� socket�� ����.
				socket = serverSocket.accept();
				System.out.println("Client ����");
				//������� ���� Thread ȣ��
				Thread t = new Thread(new ServerThread(socket));
				t.start();
				//Thread ȣ�� �� main thread�� ��� ���� ���
		}// while ����
	}
}
