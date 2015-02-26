package network.step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveString implements Runnable{
private Socket socket;
private BufferedReader br = null;

	public ReceiveString(Socket socket) throws IOException {
		this.socket=socket;
		br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));//echo 받는 리더
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		String str;
		// TODO Auto-generated method stub
		try {
			str = br.readLine();
			System.out.println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
