package bank.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ���� �޼ҵ� ����
 * ������ �޴� ����
 * ������ �޴� : 1.�������, 2.������.
 * ������� �޴� : 1. Type-������ ����.
 * ������ �޴� : 1.��ȸ, 2.������
 */
public class ServerAdministrator {
	public static void main(String[] args) {
		new Thread(new ServerSocketThread()).start();
		BufferedReader key = null;
		boolean flag = true;
		key = new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.println("������ ����");
			String confirm = key.readLine();
			while(confirm.equals("admin")){
				System.out.println("1. �������, 2.������");
				String str = key.readLine();
				if(str.equals("1")){
					System.out.println("1.��ǰ����, 2.������ ����");
					str = key.readLine();
					if(str.equals("1")){
						//TODO Type ����						
					}else if(str.equals("2")){
						//TODO ������ ����
					}
					
				}else if(str.equals("2")){
					System.out.println("1.��ȸ, 2.������");
					str = key.readLine();
					if(str.equals("1")){
						//TODO ������-��ȸ �޼ҵ� �θ���
					}else if(str.equals("2")){
						//TODO ������-������ �޼ҵ� �θ���
					}
				}
			}//while end	
		}catch(Exception e){
			e.getStackTrace();
		}
	}//main end
}//class end
