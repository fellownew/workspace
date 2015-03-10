package baseball.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 표준I/O로 값을 받고 서버로 값 보냄
 *
 */
public class BaseballPlayer {
	Socket socket;
	BufferedReader in = null;
	PrintWriter pw = null;
	public static void main(String[] args) throws Exception {
		BaseballPlayer player = new BaseballPlayer();
		player.player();
	}
	
	public void player() throws IOException{
		String str = null;
		try {
			socket = new Socket("localhost", 13678);
			pw = new PrintWriter(socket.getOutputStream(),true);
			in = new BufferedReader(new InputStreamReader(System.in));
			BaseballPlayerThread pt = new BaseballPlayerThread(socket);
			Thread t = new Thread(pt);
			t.start();//thread 시작.
			str = in.readLine();
			while (!str.equals("!@#")) {
				pw.println(str);
				str = in.readLine();
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (pw != null) {
				pw.close();
			}
			if(socket!=null){
				socket.close();
			}
		}
	}
}