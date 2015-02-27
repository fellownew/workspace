package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import util.NetworkUtil;
/**
 * main thread로부터 socket을 받아 I/OStream을 생성하여
 * client로부터 받은 문자열을 바로 되돌려줌.
 *
 */
public class ServerThread implements Runnable {
	private Socket socket = null;
	private PrintWriter pw = null;
	String nickName = null;
	
	public ServerThread(Socket socket) {
		this.socket = socket; //main으로부터 소켓을 받아옴
		try {
			pw = new PrintWriter(this.socket.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public String getNickName() {
		return nickName;
	}

	public void sendMsg(String msg){ //상대에게 msg 송출
		pw.println(msg);
	}
	
	@Override
	public void run() { // 생성자에 소켓에 대한 I/O를 모두 정의하였으므로 입출력 작업만 코딩.
		BufferedReader br = null;
		String str = null;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			nickName = br.readLine();
			System.out.println(nickName+"접속");
			pw.println("종료 : exit");
			SocketList.broadCast(nickName+"님이 입장하셨습니다."+(SocketList.numList())+"명 접속중 입니다.");
			str = br.readLine();
			while (str != null) {
				SocketList.broadCast(nickName+" : "+str);
//				pw.println(nickName+" : "+str);
				str = br.readLine();
			}//Echo 반복
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}finally{
			try {//   I/O, socket 닫기
				NetworkUtil.close(br, pw, socket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		SocketList.broadCast(nickName+"님이 나가셨습니다.");
		SocketList.removeList(this);
		System.out.println(nickName+" 종료");
	}//run 종료
}//class 종료