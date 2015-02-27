package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import util.NetworkUtil;
/**
 * main thread�κ��� socket�� �޾� I/OStream�� �����Ͽ�
 * client�κ��� ���� ���ڿ��� �ٷ� �ǵ�����.
 *
 */
public class ServerThread implements Runnable {
	private Socket socket = null;
	private PrintWriter pw = null;
	String nickName = null;
	
	public ServerThread(Socket socket) {
		this.socket = socket; //main���κ��� ������ �޾ƿ�
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

	public void sendMsg(String msg){ //��뿡�� msg ����
		pw.println(msg);
	}
	
	@Override
	public void run() { // �����ڿ� ���Ͽ� ���� I/O�� ��� �����Ͽ����Ƿ� ����� �۾��� �ڵ�.
		BufferedReader br = null;
		String str = null;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			nickName = br.readLine();
			System.out.println(nickName+"����");
			pw.println("���� : exit");
			SocketList.broadCast(nickName+"���� �����ϼ̽��ϴ�."+(SocketList.numList())+"�� ������ �Դϴ�.");
			str = br.readLine();
			while (str != null) {
				SocketList.broadCast(nickName+" : "+str);
//				pw.println(nickName+" : "+str);
				str = br.readLine();
			}//Echo �ݺ�
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}finally{
			try {//   I/O, socket �ݱ�
				NetworkUtil.close(br, pw, socket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		SocketList.broadCast(nickName+"���� �����̽��ϴ�.");
		SocketList.removeList(this);
		System.out.println(nickName+" ����");
	}//run ����
}//class ����