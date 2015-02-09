package kr.or.kosta.user;

import java.util.ArrayList;

import kr.or.kosta.service.CustomerServiceMap;
import collection.vo.Customer;

public class CustomerMain2 {

	public static void main(String[] args) {

		CustomerServiceMap service = new CustomerServiceMap();
		//����� �� ����
		Customer c1 = new Customer("id-1", "1111","�迵��",  "02-111-2222", "kys@kosta.or.kr", 10000);
		Customer c2 = new Customer("id-2", "4444","�̹̿�", "031-222-3333", "lmy@kosta.or.kr", 5500);
		Customer c3 = new Customer("id-3", "2222","�ֿ��",  "010-555-1212","cws@kosta.or.kr", 350000);
		Customer c4 = new Customer("id-4", "3333","�̹̿�",  "010-3434-5656", "lmy@kosta.or.kr", 2700);
		Customer c5 = new Customer("id-5", "5555","�̹̿�",  "031-532-6421", "Rmy@kosta.or.kr",550);
		Customer c6 = new Customer("id-6", "6666","����",  "010-9011-3222", "cks@kosta.or.kr", 66000);
		Customer c7 = new Customer("id-7", "7777","ȫ���",  "010-5434-6533", "hkb@kosta.or.kr", 57000);
				
//		--------------------------------------------------------���
		service.registerCustomer(c1);
		service.registerCustomer(c2);
		service.registerCustomer(c3);
		service.registerCustomer(c4);
		service.registerCustomer(c5);
		service.registerCustomer(c6);
		service.registerCustomer(c7);
		service.registerCustomer(new Customer("id-5", "3523","ȫ���",  "010-5434-6533", "hkb@kosta.or.kr", 57000));

		

//		-----------------------------------------------------��ü �� ���� ���
		service.printCustomerList();

//		-----------------------------------------------------ID��  �� ��ȸ
		System.out.println("------ID�� ��ȸ------");
		String findId = "id-2";
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
		int eMileage = 20000;
		System.out.println("���ϸ��� ������ üũ ("+sMileage+"~"+eMileage+")");
		ArrayList<Customer> list2 = service.findCustomerByMileageRange(sMileage, eMileage);
		if(list2==null||list2.size()==0){//���� ��ã�� ���
			System.out.println("���ϸ��� �������� ���� �����ϴ�. - main()");
		}else{
			printList(list2);
		}
		
//		-------------------------------------------------------�� ���� ����
		System.out.println("-------------------------����-----------------------");
		service.updateCustomerInfo(new Customer("id-2", "9999","�̹̿�", "031-352-1111", "newEmail@kosta.or.kr", 3000000));
		service.printCustomerList();

//		--------------------------------------------------------�� id�� ������ ����
		System.out.println("------------------����-------------------");
		service.removeCustomerById("id-5");
		service.printCustomerList();
		
	}

	public static void printList(ArrayList<Customer> list){
		for(int idx = 0; idx < list.size(); idx++){
			System.out.println(list.get(idx));
		}
	}
}



