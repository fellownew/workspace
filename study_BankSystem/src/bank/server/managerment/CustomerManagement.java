package bank.server.managerment;

import java.util.ArrayList;

import bank.server.vo.Account;
import bank.server.vo.Customer;

public class CustomerManagement {
	private static CustomerManagement inst = new CustomerManagement();
	private ArrayList<Customer> customerList;
	private CustomerManagement(){}
	public static CustomerManagement getInstance(){
		return inst;
	}
	public void addCustomer(String customerId, String customerPassword,
			String customerName, Account customerAccount,
			int creditRating, String job, int age, boolean sex,
			String phoneNumber, String adress){
		customerList.add(new Customer(customerId,customerPassword,customerName,customerAccount,creditRating,job,age,sex,phoneNumber,adress));
	}
	public ArrayList<Customer> findCustomer(){
		ArrayList<Customer> tempList=null;
		for(Customer tempCus:customerList){
			tempList.add(tempCus);
		}
		return tempList;
	}
	public void removeCustomer(String id){
		int index;
		for(index=0;index<customerList.size();index++){
			if(customerList.get(index).getCustomerId().equals(id)){//리스트들중 매개변수로 받은 아이디와 동일 아이디가 있으면 삭제
				customerList.remove(index);
				break;
			}
		}
	}
	public String confirmLogin(String customerId,String customerPassword){
		String confirm =null;
			for(Customer customer:customerList){
				if(customer.getCustomerId().equals(customerId)){
					if(customer.getCustomerPassword().equals(customerPassword)){			
					}else{
						confirm = "ID 또는 비밀번호가 틀렸습니다.";
					}
				}else{
					confirm = "ID 또는 비밀번호가 틀렸습니다.";
				}
			}
		return confirm;
	}
}
