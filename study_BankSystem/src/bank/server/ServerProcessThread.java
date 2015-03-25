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
	private BufferedReader br = null;
	private PrintWriter pw = null;
	public ServerProcessThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {

		String str = null;
		// TODO Auto-generated method stub
		try{
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pw = new PrintWriter(socket.getOutputStream());
		pw.println("1. ȸ������ 2.�α��� 3. ȸ��Ż��");
		str = br.readLine();
		if(str.equals("1")){//ȸ������
			registerCustomer();
		}else if(str.equals("2")){//�α���
			boolean flag = login();
			while(flag){//�α��� �Ϸ� ���� �۾�.
				pw.println("1.������� 2.�Ա�, 3.���, 4.�۱�, 5.����");
				str = br.readLine();
				if(str.equals("1")){//�������
						accountManage();
				}else if(str.equals("2")){//�Ա�
					
				}else if(str.equals("3")){//���
					
				}else if(str.equals("4")){//�۱�
					
				}else if(str.equals("5")){//����
					
				}else{
					pw.println("1~5�� ���ּ���");
				}
			}//while end in login
		}else if(str.equals("3")){//ȸ�� Ż��
			withdrawCustomer();
		}else{
			//�̻��� ��
		}

		}catch(IOException e){
			e.getStackTrace();
		}
	}//run end
	
	public void registerCustomer() throws IOException{
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pw = new PrintWriter(socket.getOutputStream());
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
	}//registerCustomer end
	
	public boolean login() throws IOException{
		boolean flag = false;
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pw = new PrintWriter(socket.getOutputStream());
		pw.println("�α��� ID");
		String customerId = br.readLine();
		pw.println("��й�ȣ");
		String customerPassword = br.readLine();
		//TODO ���̵� ��й�ȣ ��
		return flag;
	}
	public void withdrawCustomer() throws IOException{
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pw = new PrintWriter(socket.getOutputStream());
		pw.println("������ ID");
		String customerId = br.readLine();
		pw.println("��й�ȣ");
		String customerPassword = br.readLine();
		//TODO ���̵� ��й�ȣ ��
		cusM.removeCustomer(customerId);//����
	}
	
	public void accountManage() throws IOException{
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pw = new PrintWriter(socket.getOutputStream());
		pw.println("1.��ȸ 2.�ű� 3.����");
		String str = br.readLine();
		if(str.equals("1")){//��ȸ
			
		}else if(str.equals("2")){//�ű�
			
		}else if(str.equals("3")){//����
			
		}else{
			
		}
	}
	
}//class end
