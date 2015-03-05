package stockmarket.server;

import java.net.Socket;
/**
 * 클라이언트 1개당 1개의 쓰레드 생성.
 * 클라이언트 요청에 따라 각종 데이터 반환
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
