package kr.or.kosta.model.service;

import java.util.ArrayList;

import kr.or.kosta.vo.Customer;

public class CustomerService {
	private ArrayList customerList;

	public CustomerService() {
		customerList = new ArrayList();
	}

	public CustomerService(int listSize) {
		customerList = new ArrayList(listSize);
	}

	// 고객 가입, 중복ID 미허용
	public void registerCustomer(Customer customer) {
		String s1 = customer.getId();
		for (int i = 0; i < customerList.size(); i++) {
			if (((Customer) customerList.get(i)).getId().equals(s1)) {
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
		for (Object obj : customerList) {
			if (((Customer) obj).getId().equals(id)) {
				return (Customer) obj;
			}
		}
		return null;
	}

	// name에 의한 고객 조회
	public ArrayList findCustomerByName(String name) {
		ArrayList tempList = new ArrayList();
		for (Object obj : customerList) {
			if (((Customer) obj).getName().equals(name)) {
				tempList.add((Customer) obj);
			}
		}
		return tempList;
	}

	// mileageRange에 의한 고객조회
	public ArrayList findCustomerByMileageRange(int sM, int eM) {
		ArrayList tempList = new ArrayList();
		for (Object obj : customerList) {
			if (((Customer) obj).getMileage() >= sM
					&& ((Customer) obj).getMileage() <= eM) {
				tempList.add((Customer) obj);
			}
		}
		return tempList;
	}

	// 고객정보 변경
	public void updateCustomerInfo(Customer changeInfo) {
		String s1 = changeInfo.getId();
		for (int i = 0; i < customerList.size(); i++) {
			if (((Customer) customerList.get(i)).getId().equals(s1)) {
				customerList.set(i, changeInfo);
			}
		}
	}

	// id에 의한 고객 삭제
	public void removeCustomerById(String id) {
		for (int i = 0; i < customerList.size(); i++) {
			if (((Customer) customerList.get(i)).getId().equals(id)) {
				customerList.remove(i);
			}
		}
	}
}
