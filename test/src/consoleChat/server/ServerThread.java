package consoleChat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import consoleChat.util.NetworkUtil;
/**
 * main thread�κ��� socket�� �޾� I/OStream�� �����Ͽ�
 * client�κ��� ���� ���ڿ��� �ٷ� �ǵ�����.
 *
 */
public class ServerThread implements Runnable {
	private Socket socket = null;
	private PrintWriter pw = null;
	private BufferedReader br = null;
	private String nickName = null;
	
	public ServerThread(Socket socket) {
		this.socket = socket; //main���κ��� ������ �޾ƿ�
		try {
			pw = new PrintWriter(this.socket.getOutputStream(), true);
			br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void sendMsg(String msg){ //��뿡�� msg ����
		pw.println(msg);
	}
	
	public void expel() throws IOException{
		socket.close();
	}
	
	public String getNickName() {
		return nickName;
	}

	@Override
	public void run() { // �����ڿ� ���Ͽ� ���� I/O�� ��� �����Ͽ����Ƿ� ����� �۾��� �ڵ�.

		String str = null;
		try {
		str = br.readLine();
			if(nickName.equals("Admin")){
				String pwd;
					pwd = br.readLine();
					if(pwd.equals("1234")){
						SocketList.broadCast("�����ڰ� �����Ͽ����ϴ�.");
						System.out.println("1.��ȸ, 2.����");
						str = br.readLine();
							if(str.equals("1")){
								System.out.println(SocketList.numList());
							}else if(str.equals("2")){
								System.out.println("������ ���̵� �Է����ּ���");
								str = br.readLine();
								SocketList.expelMember(str);
							}
					}
						/*
						 * ���� ���ѵ� 
						 */
						while (str != null) {
							SocketList.broadCast(nickName+" : "+str);
//							pw.println(nickName+" : "+str);
							str = br.readLine();
						}//Echo �ݺ�
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			
		try {

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
		SocketList.broadCast(nickName+"���� �����̽��ϴ�."+(SocketList.numList())+"�� �������Դϴ�.");
		SocketList.removeList(this);
		System.out.println(nickName+" ����"+(SocketList.numList()-1)+"�� �������Դϴ�.");
	}//run ����
}//class ����