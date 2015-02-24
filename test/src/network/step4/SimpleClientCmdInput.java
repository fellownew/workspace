package network.step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import network.util.NetworkUtil;

public class SimpleClientCmdInput {
	Socket socket = null;
	BufferedReader br = null;
	BufferedReader in = null;
	PrintWriter pw = null;
	public static void main(String[] args) {
		SimpleClientCmdInput sce = new SimpleClientCmdInput();
		try {
			sce.clientEcho();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//main ����
	
	public void clientEcho() throws IOException{
		String str= null;
		String str2 = null;
		try{
			socket = new Socket("localhost",5000);
			pw =  new PrintWriter(socket.getOutputStream());//�������� ���� ���ڿ�.
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("���� : exit");
			str = in.readLine();
			while(!str.equals("exit")){
				pw.println(str);
				pw.flush();
				str2 = br.readLine();
				System.out.println(str2);
				str = in.readLine();
			}
				System.out.println("���������� �����߽��ϴ�.");	
		}finally{
			NetworkUtil.close(br, pw, socket);
			if(in!=null)in.close();
		}
		
	}//clientEcho����
}
