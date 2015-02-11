package kr.or.kosta.user;

import java.util.ArrayList;

import kr.or.kosta.CustomerService;
import kr.or.kosta.exception.LackInfoException;
import kr.or.kosta.exception.NotFindIdException;
import kr.or.kosta.exception.NotFindNameException;
import kr.or.kosta.exception.OverlapException;
import collection.vo.Customer;

public class CustomerMain {

	public static void main(String[] args) {
		CustomerService service = new CustomerService();
		//����� �� ����
		Customer c1 = new Customer("id-1", "1111","�迵��",  "02-111-2222", "kys@kosta.or.kr", 40000);
		Customer c2 = new Customer("id-2", "4444","�̹̿�", "031-222-3333", "lmy@kosta.or.kr", 5500);
		Customer c3 = new Customer("id-3", "2222","�ֿ��",  "010-555-1212","cws@kosta.or.kr", 350000);
		Customer c4 = new Customer("id-4", "3333","�̹̿�",  "010-3434-5656", "lmy@kosta.or.kr", 2700);
		Customer c5 = new Customer("id-5", "5555","�̹̿�",  "031-532-6421", "Rmy@kosta.or.kr",550);
		Customer c6 = new Customer("id-6", "6666","����",  "010-9011-3222", "cks@kosta.or.kr", 66000);
		Customer c7 = new Customer("id-7", "7777","ȫ���",  "010-5434-6533", "hkb@kosta.or.kr", 57000);
				
//		--------------------------------------------------------���
		try {
			service.registerCustomer(c1);
		service.registerCustomer(c2);
		service.registerCustomer(c3);
		service.registerCustomer(c4);
		service.registerCustomer(c5);
		service.registerCustomer(c6);
		service.registerCustomer(c7);
		service.registerCustomer(new Customer("id-5", "3523","ȫ���",  "010-5434-6533", "hkb@kosta.or.kr", 57000));
		} catch (ClassCastException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.getStackTrace();
		} catch (OverlapException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.getStackTrace();
		} catch (LackInfoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.getStackTrace();
		}

		

//		-----------------------------------------------------��ü �� ���� ���
		service.printCustomerList();

//		-----------------------------------------------------ID��  �� ��ȸ
		System.out.println("------ID�� ��ȸ------");
		String findId = "id-2";
		Customer cc;
		try {
			cc = service.findCustomerById(findId);
			System.out.println("ã�� ���� ���� : "+cc);
		} catch (NotFindIdException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.getStackTrace();
		}

		
		//--------------------------------------------------�̸����� ��ȸ
		String name = "�̹̿�";
		System.out.println("----"+name+" �� ����-----");
		
		ArrayList<Customer> list;
		try {
			list = service.findCustomerByName(name);
			printList(list);
		} catch (NotFindNameException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		
		
//		----------------------------------------------------���ϸ��� ������ ��ȸ
		int sMileage = 1000;
		int eMileage = 20000;
		System.out.println("���ϸ��� ������ üũ ("+sMileage+"~"+eMileage+")");
		list = service.findCustomerByMileageRange(sMileage, eMileage);
		if(list==null||list.size()==0){//���� ��ã�� ���
			System.out.println("���ϸ��� �������� ���� �����ϴ�.");
		}else{
			printList(list);
		}
		
//		-------------------------------------------------------�� ���� ����
		System.out.println("-------------------------����-----------------------");
//		c2.setMileage(300000);
//		c2.setEmail("newEmail@kosta.or.kr");
		try {
			service.updateCustomerInfo(new Customer("id-2", "9999","�̹̿�", "031-352-1111", "newEmail@kosta.or.kr", 3000000));
		} catch (NotFindIdException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		service.printCustomerList();

//		--------------------------------------------------------�� id�� ������ ����
		System.out.println("------------------����-------------------");
		try {
			service.removeCustomerById("id-5");
		} catch (NotFindIdException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		service.printCustomerList();
		
	}

	public static void printList(ArrayList<Customer> list){
		for(int idx = 0; idx < list.size(); idx++){
			System.out.println(list.get(idx));
		}
	}
}

