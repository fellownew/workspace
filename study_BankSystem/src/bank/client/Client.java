package bank.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * ����ڿ��� ǥ��I/O�� �Է� �޾� �������� ������.
 *
 */
public class Client {
	public static void main(String[] args) throws Exception{
		Socket socket = new Socket("127.0.0.1",9000);
		new Thread(new ClientThread(socket)).start();
		boolean flag = true;
		BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter send = new PrintWriter(socket.getOutputStream(),true);
		String str = key.readLine();
		while(flag){
			send.println(str);
			str = key.readLine();
		}
	}//main end
}//Client end
