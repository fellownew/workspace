package network.step1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import network.util.NetworkUtil;

//서버로 문자열을 보냄
public class SimpleClient {
	Socket socket = null;
	PrintWriter pw = null; // 서버에게 보낼 문자열
	public static void main(String[] args) {
		SimpleClient sc = new SimpleClient();
		try {
			sc.sendString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendString() throws IOException{
		String[] str= {"안녕하세요","2015년도","새해복 많이 받으세요"};
		try{
			socket = new Socket("localhost",5000);
			pw =  new PrintWriter(socket.getOutputStream());//서버에게 보낼 문자열.
			for(int i =0;i<str.length;i++){
				pw.println(str[i]);
			}
			
		}finally{
			NetworkUtil.close(null, pw, socket);
		}
	}
}
