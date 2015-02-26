package network.step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import network.util.NetworkUtil;

public class SimpleClientCmdInput2 {
	Socket socket = null;
	BufferedReader in = null;
	PrintWriter pw = null;

	public static void main(String[] args) {
		SimpleClientCmdInput2 sce = new SimpleClientCmdInput2();
		try {
			sce.clientEcho();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//main 종료
	
	public void clientEcho() throws IOException{
		String str= null;
		try{
			socket = new Socket("localhost",5000);//소켓으로 해당 주소 접속
			pw =  new PrintWriter(socket.getOutputStream());//서버에게 보낼 문자열.
			in = new BufferedReader(new InputStreamReader(System.in));//받을 내용
			ReceiveString rs = new ReceiveString(socket);
			Thread t = new Thread(rs);
			t.start();
			
			System.out.println("종료 : exit");
			str = in.readLine();
			while(!str.equals("exit")){
				pw.println(str);
				pw.flush();
				str = in.readLine();
			}
				System.out.println("정상적으로 종료하였습니다.");	
		}finally{
			NetworkUtil.close(in, pw, socket);
		}
		
	}//clientEcho종료
}
