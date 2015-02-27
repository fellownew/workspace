package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import util.NetworkUtil;
/**
 * Thread 작동을 위한 클래스
 * ClientChat으로부터 Socket을 받아
 * 서버에서 보내주는 문자열을 console로 출력해줌.
 */
public class ClientThread implements Runnable{
private Socket socket;


	public ClientThread(Socket socket) {
	this.socket = socket;
}

	@Override
	public void run() {
		BufferedReader br = null;
		String str = null;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true){
			str = br.readLine();
			System.out.println(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}finally{
			
//			if(br!=null){
				try {
					br.close();
					NetworkUtil.close(br, null, socket);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
//		}
		// TODO Auto-generated method stub
	}
}
