package bank.server;

import java.net.Socket;

/**
 * 소켓으로부터 정보를 받아 작업을 실행하여 소켓으로 작업 결과를 뿌려줌
 *
 */
public class ServerProcessThread implements Runnable{
	private Socket socket;
	public ServerProcessThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
