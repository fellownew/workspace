package bank.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import bank.server.managerment.AccountManagement;
import bank.server.managerment.CustomerManagement;
import bank.server.vo.Account;
import bank.server.vo.Type;

/**
 * �������κ��� ������ �޾� �۾��� �����Ͽ� �������� �۾� ����� �ѷ���
 * ����� ù �޴� : 1. ȸ������ 2.�α��� 3. ȸ��Ż��
 * �α��� ���� �޴� : 1.������� 2.�Ա�, 3.���, 4.�۱�, 5.����
 * 
 * ������� �޴� : 1.��ȸ 2.�ű� 3.����
 * 
 */
public class ServerProcessThread implements Runnable{
	private Socket socket;
	private AccountManagement accM = AccountManagement.getInstance();
	private CustomerManagement cusM = CustomerManagement.getInstance();
	public ServerProcessThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		BufferedReader br = null;
		PrintWriter pw = null;
		String str = null;
		// TODO Auto-generated method stub
		try{
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pw = new PrintWriter(socket.getOutputStream());
		pw.println("1. ȸ������ 2.�α��� 3. ȸ��Ż��");
		str = br.readLine();
		if(str.equals("1")){//ȸ������
			pw.println("������ ID");
			String customerId = br.readLine();
			pw.println("��й�ȣ");
			String customerPassword = br.readLine();
			pw.println("�̸�");
			String customerName = br.readLine();
			pw.println("����");
			String job = br.readLine();
			pw.println("���� // ���ڸ� �Է� ���ϸ� ƨ��");
			String temp = br.readLine();
			int age = Integer.parseInt(temp);
			pw.println("���� : ��/��");
			temp = br.readLine();
				boolean sex=true;
			if(temp.equals("��")){
				sex=false;
			}
			pw.println("��ȭ��ȣ");
			String phoneNumber = br.readLine();
			pw.println("�ּ�");
			String adress = br.readLine();
			pw.println("���ϴ� �����ȣ");
			temp = br.readLine();
			Account customerAccount = new Account(temp, 0, new Type("�Ϲ�", (double) 1.0));
			int creditRating = 9;
			cusM.addCustomer(customerId, customerPassword, customerName, customerAccount, creditRating, job, age, sex, phoneNumber, adress);
			
		}else if(str.equals("2")){
			
		}else if(str.equals("3")){
			
		}else{
			//�̻��� ��
		}

		}catch(IOException e){
			e.getStackTrace();
		}
	}//run end
	
	
}//class end
