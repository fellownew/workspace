package bank.server;

import java.net.Socket;

/**
 * �������κ��� ������ �޾� �۾��� �����Ͽ� �������� �۾� ����� �ѷ���
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
