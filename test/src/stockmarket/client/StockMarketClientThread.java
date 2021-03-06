package stockmarket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 서버로부터 정보를 받고 사용자에게 출력함.
 *
 */
public class StockMarketClientThread implements Runnable {
	Socket socket;

	public StockMarketClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		PrintWriter pw = null;
		String str = null;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream(),true);
			while (true) {
				str = br.readLine();
				pw.println(str);
			}
		}catch (Exception e) {
			e.getStackTrace();
		}finally{
			if(pw!=null)pw.close();
			if(br!=null)
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(socket!=null)
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
