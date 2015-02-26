package network.step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import network.util.NetworkUtil;
/**
 * 클라이언트 코드
 * socket으로 서버에 접속하여 글을 써서 서버로 보내고
 * 서버에 도착한 글이 즉시 echo되어 돌아오는 글을 console에 출력한다.
 * 이후 서버와의 I/O 반복
 * console에 exit를 입력하면 접속 종료
 */

public class SimpleClientCmdInput2 {
	Socket socket = null;
	BufferedReader br = null;
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
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));//echo 받는 리더
			in = new BufferedReader(new InputStreamReader(System.in));//받을 내용
			System.out.println("종료 : exit");
			str = in.readLine();
			while(!str.equals("exit")){
				pw.println(str);
				pw.flush();
				str = br.readLine();
				System.out.println(str);
				str = in.readLine();
			}
				System.out.println("정상적으로 종료하였습니다.");	
		}finally{
			NetworkUtil.close(br, pw, socket);
			if(in!=null)in.close();
		}
	}//clientEcho종료
}