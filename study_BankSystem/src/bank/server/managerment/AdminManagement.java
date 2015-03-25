package bank.server.managerment;

import java.util.ArrayList;

import bank.server.vo.Customer;
import bank.server.vo.Type;

/**
 * 
 * 包府磊Manager 皋家靛 包府
 * 
 * Type(惑前)包府.
 * 捞磊啦 包府
 * 绊按炼雀
 * 绊按积己
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
				//免仿
			}
		}
		
	}
	public void addCustomer(){
		
	}
	
}
