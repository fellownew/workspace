package consoleChat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import consoleChat.util.NetworkUtil;
/**
 * main thread로부터 socket을 받아 I/OStream을 생성하여
 * client로부터 받은 문자열을 바로 되돌려줌.
 *
 */
public class ServerThread implements Runnable {
	private Socket socket = null;
	private PrintWriter pw = null;
	private BufferedReader br = null;
	private String nickName = null;
	
	public ServerThread(Socket socket) {
		this.socket = socket; //main으로부터 소켓을 받아옴
		try {
			pw = new PrintWriter(this.socket.getOutputStream(), true);
			br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void sendMsg(String msg){ //상대에게 msg 송출
		pw.println(msg);
	}
	
	public void expel() throws IOException{
		socket.close();
	}
	
	public String getNickName() {
		return nickName;
	}

	@Override
	public void run() { // 생성자에 소켓에 대한 I/O를 모두 정의하였으므로 입출력 작업만 코딩.

		String str = null;
		try {
		str = br.readLine();
			if(nickName.equals("Admin")){
				String pwd;
					pwd = br.readLine();
					if(pwd.equals("1234")){
						SocketList.broadCast("관리자가 입장하였습니다.");
						System.out.println("1.조회, 2.강퇴");
						str = br.readLine();
							if(str.equals("1")){
								System.out.println(SocketList.numList());
							}else if(str.equals("2")){
								System.out.println("강퇴할 아이디 입력해주세요");
								str = br.readLine();
								SocketList.expelMember(str);
							}
					}
						/*
						 * 각종 권한들 
						 */
						while (str != null) {
							SocketList.broadCast(nickName+" : "+str);
//							pw.println(nickName+" : "+str);
							str = br.readLine();
						}//Echo 반복
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			
		try {

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
		SocketList.broadCast(nickName+"님이 나가셨습니다."+(SocketList.numList())+"명 접속중입니다.");
		SocketList.removeList(this);
		System.out.println(nickName+" 종료"+(SocketList.numList()-1)+"명 접속중입니다.");
	}//run 종료
}//class 종료