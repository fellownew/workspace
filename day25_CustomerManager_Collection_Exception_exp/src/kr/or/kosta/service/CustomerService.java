package kr.or.kosta.service;

import java.util.ArrayList;

import kr.or.kosta.exception.CustomerNotFoundException;
import kr.or.kosta.exception.DuplicatedIdException;
import kr.or.kosta.vo.Customer;

public class CustomerService {
	private ArrayList<Customer> customerList;
	
	public CustomerService(){
		//AL - �⺻ ũ��(length-������ �������� ����)�� ������ �ʰ� ����
		customerList = new ArrayList<Customer>();
	}
	public CustomerService(int listSize){
		//AL - ������ �������� ������ �Ű������� ���� ���� �̿��� ����.
		customerList = new ArrayList<Customer>(listSize);
	}
	/**
	 * ���� ����ϴ� �޼ҵ�.
	 *  - �� id (id)�� �ߺ��� �� ����.  
	 *  	- ����Ϸ��� ���� id�� ���� id�� ���� �̹� ��ϵ� ��� ��� ó�� ���� �ʴ´�. 
	 * @param customer ����� �� ������ ���� Customer��ü�� ���� �Ű�����.
	 * @throws DuplicatedIdException 
	 */
	public void registerCustomer(Customer customer) throws DuplicatedIdException{
		//id �ߺ� �˻�
		/*
		for(int idx = 0; idx < customerList.size(); idx++){
			Customer c = (Customer)customerList.get(idx);
			if(c.getId().equals(customer.getId())){//���� id�� ���� �̹� ��ϵ� �ִ�. 
				return;//ȣ���� ������ ���ư���. (return�� �޼ҵ� �߰��� ���� ��� ->�� �޼ҵ� ���� �����)
			}
		}
		*/
		Customer cust = findCustomerById(customer.getId());//����� ���� id�� ����ȸ
		if(cust!=null){//�̹� �� ID�� ��ϵ� ���ִ�.
			throw new DuplicatedIdException(customer.getId()+"�� �̹� �ִ� ���̵� �Դϴ�.");
		}
		customerList.add(customer);
	}
	/**
	 * ��ϵ� ��� ���� ������ ����ϴ� �޼ҵ�.
	 */
	public void printCustomerList(){
		for(Customer o : customerList){
			System.out.println(o);
		}
	}
//	��ȸ �޼ҵ��
	/**
	 * id�� ���� ��ȸ�ϴ� �޼ҵ�
	 * @param id ��ȸ�� ���� ID
	 * @return customerList���� ��ȸ�� ����ü. ã�� ���� ������ null�� �����Ѵ�.
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
	 * �̸����� ���� ��ȸ�ϴ� �޼ҵ�
	 * @param name ��ȸ�� ���� �̸�
	 * @return customerList���� ��ȸ�� ������ ��� ������ ArrayList
	 */
	public ArrayList<Customer>  findCustomerByName(String name){
		
		ArrayList<Customer> list = new ArrayList<Customer>();//ã�� ���� ����  list
		
		for(int idx = 0; idx < customerList.size(); idx++){
			Customer c = customerList.get(idx);
			if(name.equals(c.getName())){//�̸��� ���� �� ��ȸ
				list.add(c);
			}
		}
		return list;
	}
	/**
	 * ���ϸ��� ������ ���� ��ȸ�ϴ� �޼ҵ�.
	 * startMileage <= ��.mileage <=endMileage
	 * 
	 * @param startMileage ��ȸ������ ���� ���ϸ�����. 
	 * @param endMileage   ��ȸ������ �� ���ϸ�����
	 * @return customerList���� ��ȸ�� ������ ��� ������ ArrayList
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
	 * �Ű������� ���� ���� ���� ID�� ���� �������� ã�� ����ó��.
	 *  - �����Ϸ��� ���� ID�� ���� ��� ó���� �������� �ʴ´�.
	 * @param newCust ������ �� ����
	 * @throws CustomerNotFoundException 
	 */
	public void updateCustomerInfo(Customer newCust) throws CustomerNotFoundException{
		
		Customer cust = findCustomerById(newCust.getId());
		if(cust==null){
			throw new CustomerNotFoundException(newCust.getId()+"�� ���� ���Դϴ�.");
		}
		for(int idx = 0; idx < customerList.size(); idx++){
			Customer c = customerList.get(idx);
			if(c.getId().equals(newCust.getId())){//������ �������� ��ȸ
				customerList.set(idx, newCust);
				break;
			}
		}
	}
	/**
	 * �Ű������� ���� ID�� ���� ã�� ���� ó��
	 *  - �Ű������� ���� ID�� ���� ������ ó���� �������� �ʴ´�. 
	 * @param id
	 * @throws CustomerNotFoundException 
	 */
	public void removeCustomerById(String id) throws CustomerNotFoundException{
		Customer cust = findCustomerById(id);
		if(cust==null){
			throw new CustomerNotFoundException(id+"�� ���� ���Դϴ�.");
		}
		customerList.remove(cust);
	}
}









































