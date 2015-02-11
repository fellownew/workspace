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
		//등록할 고객 정보
		Customer c1 = new Customer("id-1", "1111","김영수",  "02-111-2222", "kys@kosta.or.kr", 40000);
		Customer c2 = new Customer("id-2", "4444","이미영", "031-222-3333", "lmy@kosta.or.kr", 5500);
		Customer c3 = new Customer("id-3", "2222","최우수",  "010-555-1212","cws@kosta.or.kr", 350000);
		Customer c4 = new Customer("id-4", "3333","이미영",  "010-3434-5656", "lmy@kosta.or.kr", 2700);
		Customer c5 = new Customer("id-5", "5555","이미영",  "031-532-6421", "Rmy@kosta.or.kr",550);
		Customer c6 = new Customer("id-6", "6666","장경수",  "010-9011-3222", "cks@kosta.or.kr", 66000);
		Customer c7 = new Customer("id-7", "7777","홍길범",  "010-5434-6533", "hkb@kosta.or.kr", 57000);
				
//		--------------------------------------------------------등록
		try {
			service.registerCustomer(c1);
		service.registerCustomer(c2);
		service.registerCustomer(c3);
		service.registerCustomer(c4);
		service.registerCustomer(c5);
		service.registerCustomer(c6);
		service.registerCustomer(c7);
		service.registerCustomer(new Customer("id-5", "3523","홍길범",  "010-5434-6533", "hkb@kosta.or.kr", 57000));
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

		

//		-----------------------------------------------------전체 고객 정보 출력
		service.printCustomerList();

//		-----------------------------------------------------ID로  고객 조회
		System.out.println("------ID로 조회------");
		String findId = "id-2";
		Customer cc;
		try {
			cc = service.findCustomerById(findId);
			System.out.println("찾은 고객의 정보 : "+cc);
		} catch (NotFindIdException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.getStackTrace();
		}

		
		//--------------------------------------------------이름으로 조회
		String name = "이미영";
		System.out.println("----"+name+" 고객 정보-----");
		
		ArrayList<Customer> list;
		try {
			list = service.findCustomerByName(name);
			printList(list);
		} catch (NotFindNameException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		
		
//		----------------------------------------------------마일리지 범위로 조회
		int sMileage = 1000;
		int eMileage = 20000;
		System.out.println("마일리지 범위로 체크 ("+sMileage+"~"+eMileage+")");
		list = service.findCustomerByMileageRange(sMileage, eMileage);
		if(list==null||list.size()==0){//고객을 못찾은 경우
			System.out.println("마일리지 범위내에 고객이 없습니다.");
		}else{
			printList(list);
		}
		
//		-------------------------------------------------------고객 정보 수정
		System.out.println("-------------------------수정-----------------------");
//		c2.setMileage(300000);
//		c2.setEmail("newEmail@kosta.or.kr");
		try {
			service.updateCustomerInfo(new Customer("id-2", "9999","이미영", "031-352-1111", "newEmail@kosta.or.kr", 3000000));
		} catch (NotFindIdException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		service.printCustomerList();

//		--------------------------------------------------------고객 id로 고객정보 제거
		System.out.println("------------------삭제-------------------");
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

