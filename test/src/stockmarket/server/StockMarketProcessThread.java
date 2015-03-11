package stockmarket.server;

import java.net.Socket;

/**
 * 클라이언트 1개당 1개의 쓰레드 생성. 클라이언트 요청에 따라 각종 데이터 반환
 * BufferedReader - socket, PrintWriter -socket
 * 데이터 처리 쓰레드
 */
public class StockMarketProcessThread implements Runnable {
	Socket socket;
	

	public StockMarketProcessThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("1.기업현황, 2.내 현황, 3.매수, 4.매도, 5.종료");
	}
	
	
}
