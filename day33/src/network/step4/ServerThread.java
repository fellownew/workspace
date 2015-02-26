package network.step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import network.util.NetworkUtil;
/**
 * main thread�κ��� socket�� �޾� I/OStream�� �����Ͽ�
 * client�κ��� ���� ���ڿ��� �ٷ� �ǵ�����.
 *
 */
public class ServerThread implements Runnable {
	private Socket socket = null;

	public ServerThread(Socket socket) {
		this.socket = socket; //main���κ��� ������ �޾ƿ�
	}

	@Override
	public void run() { // �����ڿ� ���Ͽ� ���� I/O�� ��� �����Ͽ����Ƿ� ����� �۾��� �ڵ�.
		BufferedReader br = null;
		PrintWriter pw = null;
		String str = null;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream(), true); 
			
			str = br.readLine();
			while (str != null) {
				pw.println("���� : " + str);
				str = br.readLine();
			}//Echo �ݺ�
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {//   I/O, socket �ݱ�
				NetworkUtil.close(br, pw, socket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("���� ����");
	}//run ����
}//class ����