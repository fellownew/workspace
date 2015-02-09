package kr.or.kosta.model.service;

import java.util.ArrayList;

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
	public void registerCustomer(Customer customer) {
		String s1 = customer.getId();
		for (int i = 0; i < customerList.size(); i++) {
			if ((customerList.get(i)).getId().equals(s1)) {//리스트 데이터 중 하나의 ID를 추출하여 형변환 후 비교
				System.out.println("ID가 중복됩니다. " + customer);
				return;
			}
		}
		customerList.add(customer);
	}

	// 고객리스트 출력
	public void printCustomerList() {
		for (Object o : customerList) {
			System.out.println(o);
		}
	}

	// id에 의한 고객 조회
	public Customer findCustomerById(String id) {
		for (Customer obj : customerList) {
			if (obj.getId().equals(id)) { //ID 존재하면 해당 값 형변환 하여 리턴, 없으면 null
				return obj;
			}
		}
		return null;
	}

	// name에 의한 고객 조회
	public ArrayList<Customer> findCustomerByName(String name) {
		ArrayList<Customer> tempList = new ArrayList<Customer>();
		for (Customer obj : customerList) {
			if (obj.getName().equals(name)) {
				tempList.add(obj);
			}
		}
		return tempList;
	}

	// mileageRange에 의한 고객조회
	public ArrayList<Customer> findCustomerByMileageRange(int sM, int eM) {
		ArrayList<Customer> tempList = new ArrayList<Customer>();
		for (Customer obj : customerList) {
			if (obj.getMileage() >= sM
					&& obj.getMileage() <= eM) {
				tempList.add(obj);
			}
		}
		return tempList;
	}

	// 고객정보 변경
	public void updateCustomerInfo(Customer changeInfo) {
		String s1 = changeInfo.getId();
		for (int i = 0; i < customerList.size(); i++) {
			if ((customerList.get(i)).getId().equals(s1)) {
				customerList.set(i, changeInfo);
			}
		}
	}

	// id에 의한 고객 삭제
	public void removeCustomerById(String id) {
		for (int i = 0; i < customerList.size(); i++) {
			if ((customerList.get(i)).getId().equals(id)) {
				customerList.remove(i);
			}
		}
	}
}
