package network.step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import network.util.NetworkUtil;

public class SimpleClientEcho {
	Socket socket = null;
	BufferedReader br = null;
	PrintWriter pw = null;
	public static void main(String[] args) {
		SimpleClientEcho sce = new SimpleClientEcho();
		try {
			sce.clientEcho();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//main 종료
	
	public void clientEcho() throws IOException{
		String[] str= {"안녕하세요","2015년도","새해복 많이 받으세요"};
		String str2 = null;
		try{
			socket = new Socket("localhost",5000);
			pw =  new PrintWriter(socket.getOutputStream());//서버에게 보낼 문자열.
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			for(int i =0;i<str.length;i++){
				pw.println(str[i]);
				pw.flush();
				str2 = br.readLine();
				System.out.println(str2);
			}
				System.out.println("정상적으로 전송했습니다.");	
		}finally{
			NetworkUtil.close(br, pw, socket);
		}
		
	}//clientEcho종료
}//class종료