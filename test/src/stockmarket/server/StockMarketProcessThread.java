package stockmarket.server;

import java.net.Socket;

/**
 * Ŭ���̾�Ʈ 1���� 1���� ������ ����. Ŭ���̾�Ʈ ��û�� ���� ���� ������ ��ȯ
 * BufferedReader - socket, PrintWriter -socket
 * ������ ó�� ������
 */
public class StockMarketProcessThread implements Runnable {
	Socket socket;
	

	public StockMarketProcessThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("1.�����Ȳ, 2.�� ��Ȳ, 3.�ż�, 4.�ŵ�, 5.����");
	}
	
	
}
