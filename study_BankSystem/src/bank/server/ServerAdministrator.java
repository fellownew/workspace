package bank.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * ���� �޼ҵ� ����
 * ������ �޴� ����
 *
 */
public class ServerAdministrator {
	public static void main(String[] args) {
		new Thread(new ServerSocketThread()).start();
		BufferedReader key = null;
		boolean flag = true;
		key = new BufferedReader(new InputStreamReader(System.in));
		//1.
		while(flag){
			
			
			
			
			
			
		}//while end	
	}//main end
	
}//class end
