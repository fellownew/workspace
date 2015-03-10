package kr.or.kosta.service;

import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kosta.exception.CustomerNotFoundException;
import kr.or.kosta.jdbc.CustomerDAO;
import kr.or.kosta.vo.Customer;

public class CustomerService {
	CustomerDAO dao = CustomerDAO.getInstance();
	public CustomerService(){}

	public void registerCustomer(Customer customer){
		try {
			dao.insertCustomer(customer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}

	public void printCustomerList(){
		ArrayList<Customer> customerList;
		try {
			customerList = dao.selectCustomer();
			for(Customer cust : customerList){
				System.out.println(cust);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	조회 메소드들

	public Customer findCustomerById(String id){
			try {
				Customer cust;
				cust = dao.selectCustomerById(id);
				if(cust!=null){
					return cust;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
			return null;
	}

	public ArrayList<Customer>  findCustomerByName(String name){
		
		ArrayList<Customer> list;//찾은 고객을 담을  list
		try {
			list = dao.selectCustomerByName(name);
			if(list!=null){
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Customer>  findCustomerByMileageRange(int startMileage, int endMileage){
		ArrayList<Customer> list;
		try {
			list= dao.selectCustomerBetweenMileage(startMileage, endMileage);
			if(list!=null){
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		return null;
	}

	public void updateCustomerInfo(Customer newCust) throws CustomerNotFoundException{
		try {
			int count = dao.updateCustomer(newCust);
			if(count==0){
				throw new CustomerNotFoundException(newCust.getId()+"는 없는 고객입니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}

	public void removeCustomerById(String id) throws CustomerNotFoundException{
		try {
			int count = dao.deleteCustomerById(id);
			if(count ==0){
				throw new CustomerNotFoundException(id+"는 없는 고객입니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}
}