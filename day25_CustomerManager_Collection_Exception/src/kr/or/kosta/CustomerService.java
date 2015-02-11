package kr.or.kosta;

import java.util.ArrayList;

import kr.or.kosta.exception.LackInfoException;
import kr.or.kosta.exception.NotFindIdException;
import kr.or.kosta.exception.NotFindNameException;
import kr.or.kosta.exception.OverlapException;
import collection.vo.Customer;

public class CustomerService {
	private ArrayList<Customer> customerList;

	public CustomerService() {
		customerList = new ArrayList<Customer>();
	}

	public CustomerService(int listSize) {
		customerList = new ArrayList<Customer>(listSize);
	}

	// 고객 가입, 중복ID 미허용
	public void registerCustomer(Customer customer) throws OverlapException,LackInfoException{
		//customer 확인
		String s1 = customer.getId();
		//각 회원정보가 비었거나 마일리지가 음수일경우
		 if(s1.length()<1||customer.getName().length()<1||customer.getPassword().length()<1||customer.getMileage()<0||customer.getPhoneNumber().length()<1||customer.getEmail().length()<1){
				throw new LackInfoException("회원정보가 충분치 않습니다.");//회원정보 불충분 예외
			}else if(!(verifyEmail(customer.getEmail()))){
			throw new LackInfoException("이메일 형식이 맞지 않습니다.");
		}
			//ID 중복 확인
		for (int i = 0; i < customerList.size(); i++) {
			if ((customerList.get(i)).getId().equals(s1)) {//리스트 데이터 중 하나의 ID를 추출하여 형변환 후 비교
				throw new OverlapException("동일한 ID가 존재합니다."); //ID중복에 따른 예외 처리
			}
		}
		customerList.add(customer);
	}

	// 고객리스트 출력
	public void printCustomerList() {
		for (Customer cus : customerList) {
			System.out.println(cus);
		}
	}

	// id에 의한 고객 조회
	public Customer findCustomerById(String id) throws NotFindIdException{
		for (Customer cus : customerList) {
			if (cus.getId().equals(id)) { //ID 존재하면 해당 값 형변환 하여 리턴, 없으면 null
				return cus;
			}
		}
		throw new NotFindIdException("조회할 ID가 없습니다.");
	}

	// name에 의한 고객 조회
	public ArrayList<Customer> findCustomerByName(String name)  throws NotFindNameException{
		ArrayList<Customer> tempList = new ArrayList<Customer>();
		int count = 0;
		for (Customer cus : customerList) {
			if (cus.getName().equals(name)) {
				tempList.add(cus);
				count++;
			}
		}
		if(count==0){
			throw new NotFindNameException("조회할 이름이 없습니다.");
			}
		return tempList;
	}

	// mileageRange에 의한 고객조회
	public ArrayList<Customer> findCustomerByMileageRange(int sM, int eM) {
		ArrayList<Customer> tempList = new ArrayList<Customer>();
		for (Customer cus : customerList) {
			if (cus.getMileage() >= sM
					&& cus.getMileage() <= eM) {
				tempList.add(cus);
			}
		}
		return tempList;
	}

	// 고객정보 변경
	public void updateCustomerInfo(Customer changeInfo)  throws NotFindIdException{
		String s1 = changeInfo.getId();
		boolean b = true;
		for (int i = 0; i < customerList.size(); i++) {
			if ((customerList.get(i)).getId().equals(s1)) {
				customerList.set(i, changeInfo);
				b=false;
			}
			}
		if(b){
			throw new NotFindIdException("수정할 ID가 없습니다.");
		}
		
	}

	// id에 의한 고객 삭제
	public void removeCustomerById(String id)  throws NotFindIdException{
		boolean b = true;
		for (int i = 0; i < customerList.size(); i++) {
			if ((customerList.get(i)).getId().equals(id)) {
				customerList.remove(i);
				b=false;
			}
		}		if(b){
			throw new NotFindIdException("삭제할 ID가 없습니다.");
		}
	}
	//이메일 형식 확인
	public static boolean verifyEmail(String email){
		boolean b = false;
		for(int i=0;i<email.length();i++){
			if(email.charAt(i)=='@'){
				b=true;
			}
		}
		return b;
	}
	
}//class 끝