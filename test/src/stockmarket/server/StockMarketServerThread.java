package stockmarket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 소켓 생성 및 소켓 대기를 위한 쓰레드
 * 소켓을 받으면 StockMarketServerReturnThread에 소켓을 넘겨 호출.
 *
 */
public class StockMarketServerThread implements Runnable {
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
			StockMarketProcessThread thread1 = new StockMarketProcessThread(socket);
			Thread t1 = new Thread(thread1);
			t1.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}