package network.step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import network.util.NetworkUtil;
/**
 * main thread로부터 socket을 받아 I/OStream을 생성하여
 * client로부터 받은 문자열을 바로 되돌려줌.
 *
 */
public class ServerThread implements Runnable {
	private Socket socket = null;

	public ServerThread(Socket socket) {
		this.socket = socket; //main으로부터 소켓을 받아옴
	}

	@Override
	public void run() { // 생성자에 소켓에 대한 I/O를 모두 정의하였으므로 입출력 작업만 코딩.
		BufferedReader br = null;
		PrintWriter pw = null;
		String str = null;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream(), true); 
			
			str = br.readLine();
			while (str != null) {
				pw.println("내용 : " + str);
				str = br.readLine();
			}//Echo 반복
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {//   I/O, socket 닫기
				NetworkUtil.close(br, pw, socket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("접속 종료");
	}//run 종료
}//class 종료