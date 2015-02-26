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
		this.socket = socket; //main���κ��� ������ �޾ƿ�
		this.member = member;
		try {
			br = new BufferedReader(new InputStreamReader(this.socket.getInputStream())); //�ش� ���� ����
			pw = new PrintWriter(this.socket.getOutputStream(), true); // �ش� ���� ������
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// ���ڿ� ����
	}

	@Override
	public void run() { // �����ڿ� ���Ͽ� ���� I/O�� ��� �����Ͽ����Ƿ� ����� �۾��� �ڵ�.
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
		System.out.println("���� ����");
	}
}