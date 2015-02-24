package network.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import network.util.NetworkUtil;

public class SimpleClientEcho {
	Socket socket = null;
	BufferedReader br = null;
	PrintWriter pw = null;
	public static void main(String[] args) {
		SimpleClientEcho sce = new SimpleClientEcho();
		try {
			sce.clientEcho();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//main ����
	
	public void clientEcho() throws IOException{
		String[] str= {"�ȳ��ϼ���","2015�⵵","���غ� ���� ��������"};
		try{
			socket = new Socket("localhost",5000);

			pw =  new PrintWriter(socket.getOutputStream());//�������� ���� ���ڿ�.
			for(int i =0;i<str.length;i++){
				pw.println(str[i]);
				pw.flush();
			}
				System.out.println("���������� �����߽��ϴ�.");
				
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				System.out.println("- Echo ���� - ");
				String str2 = br.readLine();
				while (str2 != null) {
					System.out.println(str2);
					str2 = br.readLine();
				}
				
		}finally{
			NetworkUtil.close(br, pw, socket);
		}
		
	}//clientEcho����
}//class����