package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import util.NetworkUtil;
/**
 * 클라이언트 코드
 * socket으로 서버에 접속
 * 표준I/O로부터 문자열을 입력받아 서버에 보냄.
 * 이후 서버와의 I/O 반복
 * 서버에서 들어오는 글은 ClientThread에서 Console에 출력.
 * console에 exit를 입력하면 접속 종료
 */

public class ClientChat {
	Socket socket = null;
	BufferedReader in = null;
	PrintWriter pw = null;
	public static void main(String[] args) {
		ClientChat sce = new ClientChat();
		try {
			sce.connectChat();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//main 종료
	
	public void connectChat() throws IOException{
		String str= null;
		try{
			socket = new Socket("localhost",5000);//소켓으로 해당 주소 접속
			pw =  new PrintWriter(socket.getOutputStream());//서버에게 보낼 문자열.
			in = new BufferedReader(new InputStreamReader(System.in));//받을 내용
			Thread t = new Thread(new ClientThread(socket));
			t.start();
			System.out.println("대화명을 입력하세요");
			pw.println(in.readLine());
			pw.flush();
			str = in.readLine();
			while(!str.equals("exit")){
//				pw.println(name +" : "+str);
				pw.println(str);
				pw.flush();
				str = in.readLine();
			}
		}finally{
			NetworkUtil.close(in, pw, socket);
			System.out.println("정상적으로 종료하였습니다.");
		}
	}//clientEcho종료
}