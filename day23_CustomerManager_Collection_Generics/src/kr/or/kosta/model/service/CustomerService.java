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

	// �� ����, �ߺ�ID �����
	public void registerCustomer(Customer customer) {
		String s1 = customer.getId();
		for (int i = 0; i < customerList.size(); i++) {
			if ((customerList.get(i)).getId().equals(s1)) {//����Ʈ ������ �� �ϳ��� ID�� �����Ͽ� ����ȯ �� ��
				System.out.println("ID�� �ߺ��˴ϴ�. " + customer);
				return;
			}
		}
		customerList.add(customer);
	}

	// ������Ʈ ���
	public void printCustomerList() {
		for (Object o : customerList) {
			System.out.println(o);
		}
	}

	// id�� ���� �� ��ȸ
	public Customer findCustomerById(String id) {
		for (Customer obj : customerList) {
			if (obj.getId().equals(id)) { //ID �����ϸ� �ش� �� ����ȯ �Ͽ� ����, ������ null
				return obj;
			}
		}
		return null;
	}

	// name�� ���� �� ��ȸ
	public ArrayList<Customer> findCustomerByName(String name) {
		ArrayList<Customer> tempList = new ArrayList<Customer>();
		for (Customer obj : customerList) {
			if (obj.getName().equals(name)) {
				tempList.add(obj);
			}
		}
		return tempList;
	}

	// mileageRange�� ���� ����ȸ
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

	// ������ ����
	public void updateCustomerInfo(Customer changeInfo) {
		String s1 = changeInfo.getId();
		for (int i = 0; i < customerList.size(); i++) {
			if ((customerList.get(i)).getId().equals(s1)) {
				customerList.set(i, changeInfo);
			}
		}
	}

	// id�� ���� �� ����
	public void removeCustomerById(String id) {
		for (int i = 0; i < customerList.size(); i++) {
			if ((customerList.get(i)).getId().equals(id)) {
				customerList.remove(i);
			}
		}
	}
}
