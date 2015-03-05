package stockmarket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
/**
 * ����ڷκ��� �Է¹ް� ������ �����͸� ������.
 *
 */
public class StockMarketClient {

	public static void main(String[] args) {
		StockMarketClient player = new StockMarketClient();
		player.playMarket();
	}
	
	
	public void playMarket(){
		BufferedReader br = null;
		PrintWriter pw = null;
		Socket socket = null;
		String str = null;
		try{
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("���� �����Ǹ� �Է����ּ���");
		String address = br.readLine();
		System.out.println("���� ��Ʈ�� �Է����ּ���");
		String port = br.readLine();
		socket = new Socket(address,Integer.parseInt(port));
		pw = new PrintWriter(socket.getOutputStream(),true);
		StockMarketClientThread thread = new StockMarketClientThread(socket);
		Thread t1 = new Thread(thread);
		t1.start();
			while(true){
				System.out.println("1.�����Ȳ, 2.�� ��Ȳ, 3.�ż�, 4.�ŵ�, 5.����");
					str = br.readLine();
					if(1<=Integer.parseInt(str)&&Integer.parseInt(str)<=5){
						pw.println(str);
					}
			}
		}catch(Exception e){
			e.getStackTrace();
		}finally{
			if(pw!=null)pw.close();
			if(br!=null)
				try {
					br.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			if(socket!=null)
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}