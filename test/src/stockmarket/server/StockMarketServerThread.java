package stockmarket.server;

import java.net.Socket;
/**
 * Ŭ���̾�Ʈ 1���� 1���� ������ ����.
 * Ŭ���̾�Ʈ ��û�� ���� ���� ������ ��ȯ
 *
 */
public class StockMarketServerThread implements Runnable{
Socket socket;

	public StockMarketServerThread(Socket socket) {
	this.socket = socket;
}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
