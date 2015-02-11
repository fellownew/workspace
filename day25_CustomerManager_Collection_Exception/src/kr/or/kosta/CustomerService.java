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

	// �� ����, �ߺ�ID �����
	public void registerCustomer(Customer customer) throws OverlapException,LackInfoException{
		//customer Ȯ��
		String s1 = customer.getId();
		//�� ȸ�������� ����ų� ���ϸ����� �����ϰ��
		 if(s1.length()<1||customer.getName().length()<1||customer.getPassword().length()<1||customer.getMileage()<0||customer.getPhoneNumber().length()<1||customer.getEmail().length()<1){
				throw new LackInfoException("ȸ�������� ���ġ �ʽ��ϴ�.");//ȸ������ ����� ����
			}else if(!(verifyEmail(customer.getEmail()))){
			throw new LackInfoException("�̸��� ������ ���� �ʽ��ϴ�.");
		}
			//ID �ߺ� Ȯ��
		for (int i = 0; i < customerList.size(); i++) {
			if ((customerList.get(i)).getId().equals(s1)) {//����Ʈ ������ �� �ϳ��� ID�� �����Ͽ� ����ȯ �� ��
				throw new OverlapException("������ ID�� �����մϴ�."); //ID�ߺ��� ���� ���� ó��
			}
		}
		customerList.add(customer);
	}

	// ������Ʈ ���
	public void printCustomerList() {
		for (Customer cus : customerList) {
			System.out.println(cus);
		}
	}

	// id�� ���� �� ��ȸ
	public Customer findCustomerById(String id) throws NotFindIdException{
		for (Customer cus : customerList) {
			if (cus.getId().equals(id)) { //ID �����ϸ� �ش� �� ����ȯ �Ͽ� ����, ������ null
				return cus;
			}
		}
		throw new NotFindIdException("��ȸ�� ID�� �����ϴ�.");
	}

	// name�� ���� �� ��ȸ
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
			throw new NotFindNameException("��ȸ�� �̸��� �����ϴ�.");
			}
		return tempList;
	}

	// mileageRange�� ���� ����ȸ
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

	// ������ ����
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
			throw new NotFindIdException("������ ID�� �����ϴ�.");
		}
		
	}

	// id�� ���� �� ����
	public void removeCustomerById(String id)  throws NotFindIdException{
		boolean b = true;
		for (int i = 0; i < customerList.size(); i++) {
			if ((customerList.get(i)).getId().equals(id)) {
				customerList.remove(i);
				b=false;
			}
		}		if(b){
			throw new NotFindIdException("������ ID�� �����ϴ�.");
		}
	}
	//�̸��� ���� Ȯ��
	public static boolean verifyEmail(String email){
		boolean b = false;
		for(int i=0;i<email.length();i++){
			if(email.charAt(i)=='@'){
				b=true;
			}
		}
		return b;
	}
	
}//class ��