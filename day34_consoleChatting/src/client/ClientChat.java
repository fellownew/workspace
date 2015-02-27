package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import util.NetworkUtil;
/**
 * Ŭ���̾�Ʈ �ڵ�
 * socket���� ������ ����
 * ǥ��I/O�κ��� ���ڿ��� �Է¹޾� ������ ����.
 * ���� �������� I/O �ݺ�
 * �������� ������ ���� ClientThread���� Console�� ���.
 * console�� exit�� �Է��ϸ� ���� ����
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
	}//main ����
	
	public void connectChat() throws IOException{
		String str= null;
		try{
			socket = new Socket("localhost",5000);//�������� �ش� �ּ� ����
			pw =  new PrintWriter(socket.getOutputStream());//�������� ���� ���ڿ�.
			in = new BufferedReader(new InputStreamReader(System.in));//���� ����
			Thread t = new Thread(new ClientThread(socket));
			t.start();
			System.out.println("��ȭ���� �Է��ϼ���");
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
			System.out.println("���������� �����Ͽ����ϴ�.");
		}
	}//clientEcho����
}