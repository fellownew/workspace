package kr.or.kosta.user;

import java.util.ArrayList;

import kr.or.kosta.exception.CustomerNotFoundException;
import kr.or.kosta.service.CustomerService;
import kr.or.kosta.vo.Customer;

public class CustomerMain {

	public static void main(String[] args) {
		CustomerService service = new CustomerService();
//		CustomerServiceMap service = new CustomerServiceMap();
		//등록할 고객 정보
		Customer c1 = new Customer("id-1", "1111","김영수", "kys@kosta.or.kr", "02-111-2222", 40000);
		Customer c2 = new Customer("id-2", "4444","이미영", "lmy@kosta.or.kr", "031-222-3333", 5500);
		Customer c3 = new Customer("id-3", "2222","최우수", "cws@kosta.or.kr", "010-555-1212",350000);
		Customer c4 = new Customer("id-4", "3333","이미영",  "lmy@kosta.or.kr", "010-3434-5656", 2700);
		Customer c5 = new Customer("id-5", "5555","이미영",  "Rmy@kosta.or.kr", "031-532-6421", 550);
		Customer c6 = new Customer("id-6", "6666","장경수",  "cks@kosta.or.kr", "010-9011-3222", 66000);
		Customer c7 = new Customer("id-7", "7777","홍길범",  "hkb@kosta.or.kr", "010-5434-6533", 57000);
		
		Customer c8 = new Customer("id-7", "7777","홍길범", "hkb@kosta.or.kr",   "010-5434-6533",57000);
		
		service.registerCustomer(c1);
		service.registerCustomer(c2);
		service.registerCustomer(c3);
		service.registerCustomer(c4);
		service.registerCustomer(c5);
		service.registerCustomer(c6);
		service.registerCustomer(c7);
		service.registerCustomer(c8);//중복 ID
		
		

//		-----------------------------------------------------전체 고객 정보 출력
		service.printCustomerList();

//		-----------------------------------------------------ID로  고객 조회
		String findId = "id-20";
		Customer cc = service.findCustomerById(findId);
		if(cc==null){
			System.out.println(findId+"는 없는 고객입니다.");
		}else{
			System.out.println("찾은 고객의 정보 : "+cc);
		}
				
		//--------------------------------------------------이름으로 조회
		String name = "이미영";
		System.out.println("----"+name+" 고객 정보-----");
		
		ArrayList<Customer> list = service.findCustomerByName(name);
		
		if(list==null||list.size()==0){//고객을 못찾은 경우
			System.out.println(name+"는 없는 고객 - main()");
		}else{
			printList(list);
		}
	
//		----------------------------------------------------마일리지 범위로 조회
		int sMileage = 1000;
		int eMileage = 200000;
		System.out.println("마일리지 범위로 체크 ("+sMileage+"~"+eMileage+")");
		list = service.findCustomerByMileageRange(sMileage, eMileage);
		if(list==null||list.size()==0){//고객을 못찾은 경우
			System.out.println("마일리지 범위내에 고객이 없습니다. - main()");
		}else{
			printList(list);
		}
				
//		-------------------------------------------------------고객 정보 수정 수정
		System.out.println("-------------------------수정-----------------------");
//		c2.setMileage(300000);
//		c2.setEmail("newEmail@kosta.or.kr");
//		Customer newCust = new Customer("id-3","2222","최우수",  "010-555-1212","newEmail@kosta.or.kr", 300000);
		Customer newCust = new Customer("id-33","2222","최우수",  "010-555-1212","newEmail@kosta.or.kr", 300000);
		try {
			service.updateCustomerInfo(newCust);
			service.printCustomerList();
		} catch (CustomerNotFoundException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		

//		--------------------------------------------------------고객 id로 고객정보 제거
		System.out.println("------------------삭제-------------------");
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
		
		System.out.println("-------------main 종료-------------");
	}

	public static void printList(ArrayList<Customer> list){
		for(int idx = 0; idx < list.size(); idx++){
			System.out.println(list.get(idx));
		}
	}
}

