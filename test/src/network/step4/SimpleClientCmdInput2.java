package network.step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import network.util.NetworkUtil;

public class SimpleClientCmdInput2 {
	Socket socket = null;
	BufferedReader in = null;
	PrintWriter pw = null;

	public static void main(String[] args) {
		SimpleClientCmdInput2 sce = new SimpleClientCmdInput2();
		try {
			sce.clientEcho();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//main ����
	
	public void clientEcho() throws IOException{
		String str= null;
		try{
			socket = new Socket("localhost",5000);//�������� �ش� �ּ� ����
			pw =  new PrintWriter(socket.getOutputStream());//�������� ���� ���ڿ�.
			in = new BufferedReader(new InputStreamReader(System.in));//���� ����
			ReceiveString rs = new ReceiveString(socket);
			Thread t = new Thread(rs);
			t.start();
			
			System.out.println("���� : exit");
			str = in.readLine();
			while(!str.equals("exit")){
				pw.println(str);
				pw.flush();
				str = in.readLine();
			}
				System.out.println("���������� �����Ͽ����ϴ�.");	
		}finally{
			NetworkUtil.close(in, pw, socket);
		}
		
	}//clientEcho����
}
