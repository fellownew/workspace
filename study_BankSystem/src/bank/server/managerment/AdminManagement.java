package bank.server.managerment;

import java.util.ArrayList;

import bank.server.vo.Customer;
import bank.server.vo.Type;

/**
 * 
 * ������Manager �޼ҵ� ����
 * 
 * Type(��ǰ)����.
 * ������ ����
 * ����ȸ
 * ������
 */
public class AdminManagement {
	AccountManagement accM=AccountManagement.getInstance();
	CustomerManagement cusM = CustomerManagement.getInstance();
	public void findInterest(){
		
	}
	public void setInterest(Type type){
		
	}
	public void findCustomer(){
		ArrayList<Customer> cusList = cusM.findCustomer();
		if(cusList!=null){
			for(Customer cus:cusList){
				//���
			}
		}
		
	}
	public void addCustomer(){
		
	}
	
}
