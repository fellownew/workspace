package kr.or.kosta.user;

import java.util.ArrayList;

import kr.or.kosta.exception.CustomerNotFoundException;
import kr.or.kosta.service.CustomerService;
import kr.or.kosta.vo.Customer;

public class CustomerMain {

	public static void main(String[] args) {
		CustomerService service = new CustomerService();
//		CustomerServiceMap service = new CustomerServiceMap();
		//����� �� ����
		Customer c1 = new Customer("id-1", "1111","�迵��", "kys@kosta.or.kr", "02-111-2222", 40000);
		Customer c2 = new Customer("id-2", "4444","�̹̿�", "lmy@kosta.or.kr", "031-222-3333", 5500);
		Customer c3 = new Customer("id-3", "2222","�ֿ��", "cws@kosta.or.kr", "010-555-1212",350000);
		Customer c4 = new Customer("id-4", "3333","�̹̿�",  "lmy@kosta.or.kr", "010-3434-5656", 2700);
		Customer c5 = new Customer("id-5", "5555","�̹̿�",  "Rmy@kosta.or.kr", "031-532-6421", 550);
		Customer c6 = new Customer("id-6", "6666","����",  "cks@kosta.or.kr", "010-9011-3222", 66000);
		Customer c7 = new Customer("id-7", "7777","ȫ���",  "hkb@kosta.or.kr", "010-5434-6533", 57000);
		
		Customer c8 = new Customer("id-7", "7777","ȫ���", "hkb@kosta.or.kr",   "010-5434-6533",57000);
		
		service.registerCustomer(c1);
		service.registerCustomer(c2);
		service.registerCustomer(c3);
		service.registerCustomer(c4);
		service.registerCustomer(c5);
		service.registerCustomer(c6);
		service.registerCustomer(c7);
		service.registerCustomer(c8);//�ߺ� ID
		
		

//		-----------------------------------------------------��ü �� ���� ���
		service.printCustomerList();

//		-----------------------------------------------------ID��  �� ��ȸ
		String findId = "id-20";
		Customer cc = service.findCustomerById(findId);
		if(cc==null){
			System.out.println(findId+"�� ���� ���Դϴ�.");
		}else{
			System.out.println("ã�� ���� ���� : "+cc);
		}
				
		//--------------------------------------------------�̸����� ��ȸ
		String name = "�̹̿�";
		System.out.println("----"+name+" �� ����-----");
		
		ArrayList<Customer> list = service.findCustomerByName(name);
		
		if(list==null||list.size()==0){//���� ��ã�� ���
			System.out.println(name+"�� ���� �� - main()");
		}else{
			printList(list);
		}
	
//		----------------------------------------------------���ϸ��� ������ ��ȸ
		int sMileage = 1000;
		int eMileage = 200000;
		System.out.println("���ϸ��� ������ üũ ("+sMileage+"~"+eMileage+")");
		list = service.findCustomerByMileageRange(sMileage, eMileage);
		if(list==null||list.size()==0){//���� ��ã�� ���
			System.out.println("���ϸ��� �������� ���� �����ϴ�. - main()");
		}else{
			printList(list);
		}
				
//		-------------------------------------------------------�� ���� ���� ����
		System.out.println("-------------------------����-----------------------");
//		c2.setMileage(300000);
//		c2.setEmail("newEmail@kosta.or.kr");
//		Customer newCust = new Customer("id-3","2222","�ֿ��",  "010-555-1212","newEmail@kosta.or.kr", 300000);
		Customer newCust = new Customer("id-33","2222","�ֿ��",  "010-555-1212","newEmail@kosta.or.kr", 300000);
		try {
			service.updateCustomerInfo(newCust);
			service.printCustomerList();
		} catch (CustomerNotFoundException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		

//		--------------------------------------------------------�� id�� ������ ����
		System.out.println("------------------����-------------------");
//		String delId = "id-5";
		String delId = "id-55";
		try {
			service.removeCustomerById(delId);
			service.printCustomerList();
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		System.out.println("-------------main ����-------------");
	}

	public static void printList(ArrayList<Customer> list){
		for(int idx = 0; idx < list.size(); idx++){
			System.out.println(list.get(idx));
		}
	}
}

