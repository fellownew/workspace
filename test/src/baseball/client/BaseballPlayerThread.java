package baseball.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
/**
 * 서버로부터 항상 받고
 * 사용자에게 출력
 */
public class BaseballPlayerThread implements Runnable{
	Socket socket;
	public BaseballPlayerThread(Socket socket) {
		this.socket = socket;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run(){
		System.out.println("c1");
		BufferedReader br = null;
		String str = null;
		try{
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true){
				str = br.readLine();
				System.out.println(str);
			}
		}catch(Exception e ){
			e.getStackTrace();
		}finally{
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(socket!=null){
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}