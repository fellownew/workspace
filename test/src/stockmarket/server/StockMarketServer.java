package stockmarket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * ���� ���� �� ���� ��⸦ ���� ������
 * ������ ������ StockMarketServerResultThread�� ������ �Ѱ� ȣ��.
 *
 */
public class StockMarketServer implements Runnable {
	ServerSocket serverSocket = null;;
	Socket socket = null;

	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(9500);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			socket = serverSocket.accept();
			StockMarketServerThread thread1 = new StockMarketServerThread(socket);
			Thread t1 = new Thread(thread1);
			t1.start();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}