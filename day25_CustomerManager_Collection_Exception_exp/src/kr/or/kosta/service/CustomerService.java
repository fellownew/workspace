package kr.or.kosta.service;

import java.util.ArrayList;

import kr.or.kosta.exception.CustomerNotFoundException;
import kr.or.kosta.exception.DuplicatedIdException;
import kr.or.kosta.vo.Customer;

public class CustomerService {
	private ArrayList<Customer> customerList;
	
	public CustomerService(){
		//AL - 기본 크기(length-저장할 데이터의 개수)를 정하지 않고 생성
		customerList = new ArrayList<Customer>();
	}
	public CustomerService(int listSize){
		//AL - 저장할 데이터의 개수를 매개변수로 받은 값을 이용해 생성.
		customerList = new ArrayList<Customer>(listSize);
	}
	/**
	 * 고객을 등록하는 메소드.
	 *  - 고객 id (id)는 중복될 수 없다.  
	 *  	- 등록하려는 고객의 id와 같은 id의 고객이 이미 등록된 경우 등록 처리 하지 않는다. 
	 * @param customer 등록할 고객 정보를 가진 Customer객체를 받을 매개변수.
	 * @throws DuplicatedIdException 
	 */
	public void registerCustomer(Customer customer) throws DuplicatedIdException{
		//id 중복 검사
		/*
		for(int idx = 0; idx < customerList.size(); idx++){
			Customer c = (Customer)customerList.get(idx);
			if(c.getId().equals(customer.getId())){//같은 id의 고객이 이미 등록되 있다. 
				return;//호출한 곳으로 돌아가라. (return이 메소드 중간에 쓰인 경우 ->이 메소드 수행 멈춰라)
			}
		}
		*/
		Customer cust = findCustomerById(customer.getId());//등록할 고객의 id로 고객조회
		if(cust!=null){//이미 그 ID로 등록된 고객있다.
			throw new DuplicatedIdException(customer.getId()+"는 이미 있는 아이디 입니다.");
		}
		customerList.add(customer);
	}
	/**
	 * 등록된 모든 고객의 정보를 출력하는 메소드.
	 */
	public void printCustomerList(){
		for(Customer o : customerList){
			System.out.println(o);
		}
	}
//	조회 메소드들
	/**
	 * id로 고객을 조회하는 메소드
	 * @param id 조회할 고객의 ID
	 * @return customerList에서 조회한 고객객체. 찾는 고객이 없으면 null을 리턴한다.
	 */
	public Customer findCustomerById(String id){
		
		for(int idx = 0; idx < customerList.size(); idx++){
			Customer cust = customerList.get(idx);
			if(id.equals(cust.getId())){
				return cust;
			}
		}
		return null;
	}
	/**
	 * 이름으로 고객을 조회하는 메소드
	 * @param name 조회할 고객의 이름
	 * @return customerList에서 조회된 고객들을 담아 리턴할 ArrayList
	 */
	public ArrayList<Customer>  findCustomerByName(String name){
		
		ArrayList<Customer> list = new ArrayList<Customer>();//찾은 고객을 담을  list
		
		for(int idx = 0; idx < customerList.size(); idx++){
			Customer c = customerList.get(idx);
			if(name.equals(c.getName())){//이름이 같은 고객 조회
				list.add(c);
			}
		}
		return list;
	}
	/**
	 * 마일리지 범위로 고객을 조회하는 메소드.
	 * startMileage <= 고객.mileage <=endMileage
	 * 
	 * @param startMileage 조회범위의 시작 마일리지값. 
	 * @param endMileage   조회범위의 끝 마일리지값
	 * @return customerList에서 조회된 고객들을 담아 리턴할 ArrayList
	 */
	public ArrayList<Customer>  findCustomerByMileageRange(int startMileage, int endMileage){
		ArrayList<Customer> list = new ArrayList<Customer>();
		
		for(int idx = 0; idx < customerList.size(); idx++){
			Customer c = customerList.get(idx);
			if(c.getMileage()>=startMileage&&c.getMileage() <= endMileage){
				list.add(c);
			}
		}
		return list;
	}
	/**
	 * 매개변수로 받은 고객과 같은 ID를 가진 고객정보를 찾아 변경처리.
	 *  - 수정하려는 고객의 ID가 없는 경우 처리를 진행하지 않는다.
	 * @param newCust 변경할 고객 정보
	 * @throws CustomerNotFoundException 
	 */
	public void updateCustomerInfo(Customer newCust) throws CustomerNotFoundException{
		
		Customer cust = findCustomerById(newCust.getId());
		if(cust==null){
			throw new CustomerNotFoundException(newCust.getId()+"는 없는 고객입니다.");
		}
		for(int idx = 0; idx < customerList.size(); idx++){
			Customer c = customerList.get(idx);
			if(c.getId().equals(newCust.getId())){//변경할 고객정보를 조회
				customerList.set(idx, newCust);
				break;
			}
		}
	}
	/**
	 * 매개변수로 받은 ID의 고객을 찾아 삭제 처리
	 *  - 매개변수로 받은 ID의 고객이 없으면 처리를 진행하지 않는다. 
	 * @param id
	 * @throws CustomerNotFoundException 
	 */
	public void removeCustomerById(String id) throws CustomerNotFoundException{
		Customer cust = findCustomerById(id);
		if(cust==null){
			throw new CustomerNotFoundException(id+"는 없는 고객입니다.");
		}
		customerList.remove(cust);
	}
}









































