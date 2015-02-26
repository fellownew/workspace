package network.step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread implements Runnable {
	Socket socket = null;
	BufferedReader br = null;
	PrintWriter pw = null;
	ArrayList<Socket> member;


	public ServerThread(Socket socket,ArrayList<Socket> member) {
		this.socket = socket; //main으로부터 소켓을 받아옴
		this.member = member;
		try {
			br = new BufferedReader(new InputStreamReader(this.socket.getInputStream())); //해당 소켓 리더
			pw = new PrintWriter(this.socket.getOutputStream(), true); // 해당 소켓 프린터
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 문자열 리더
	}

	@Override
	public void run() { // 생성자에 소켓에 대한 I/O를 모두 정의하였으므로 입출력 작업만 코딩.
		String str = null;
		try {
			str = br.readLine();
			while (str != null) {
				pw.println(" ID : " + str);
				str = br.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("접속 종료");
	}
}