package network.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//������ ���ڿ��� ����
public class SimpleClient {
	Socket socket = null;
	PrintWriter pw = null; // �������� ���� ���ڿ�
	BufferedReader br = null;
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
		String str= null;
		try{
			socket = new Socket("localhost",5000);
			pw =  new PrintWriter(socket.getOutputStream());//�������� ���� ���ڿ�.
			br = new BufferedReader(new InputStreamReader(System.in));
			str = br.readLine();
			while(str!=null){
				pw.println(str);
				pw.flush();
				str = br.readLine();
			}			
		}finally{
			if(pw!=null){
				pw.close();
			}
			if(socket!=null){
				socket.close();
			}
		}
	}
}