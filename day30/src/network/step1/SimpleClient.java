package network.step1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import network.util.NetworkUtil;

//������ ���ڿ��� ����
public class SimpleClient {
	Socket socket = null;
	PrintWriter pw = null; // �������� ���� ���ڿ�
	public static void main(String[] args) {
		SimpleClient sc = new SimpleClient();
		try {
			sc.sendString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendString() throws IOException{
		String[] str= {"�ȳ��ϼ���","2015�⵵","���غ� ���� ��������"};
		try{
			socket = new Socket("localhost",5000);
			pw =  new PrintWriter(socket.getOutputStream());//�������� ���� ���ڿ�.
			for(int i =0;i<str.length;i++){
				pw.println(str[i]);
			}
			
		}finally{
			NetworkUtil.close(null, pw, socket);
		}
	}
}
