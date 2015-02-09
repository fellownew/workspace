package kr.or.kosta.service;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

import collection.vo.Customer;

public class CustomerServiceMap {
private TreeMap<String,Customer> customMap;

//ID�� Ű�� ����ϴ� map���� ���.

public CustomerServiceMap(){
	customMap=new TreeMap<String,Customer>();
}

// �� ����, �ߺ�ID �����
public void registerCustomer(Customer customer) {
	String s1 = customer.getId();
	if(customMap.containsKey(s1)){
		System.out.println("�̹� ��ϵ� ID �Դϴ�.");
		return;
	}
	customMap.put(s1,customer);
}

// ������Ʈ ���
public void printCustomerList() {
	Set<String> keys = customMap.keySet();//map�� Ű���� set���� ����.
	for(String key:keys){
		System.out.println(customMap.get(key));//Ű�� �� Ű�� �ִ� ���� for������ ���
	}
}

// id�� ���� �� ��ȸ
public Customer findCustomerById(String id) {
		return customMap.get(id);
	}
	
// name�� ���� �� ��ȸ
public ArrayList<Customer> findCustomerByName(String name) {
	Set<String> keys = customMap.keySet();//map�� Ű���� set���� ����.
	ArrayList<Customer> list = new ArrayList<Customer>();
	for(String key:keys){
		if((customMap.get(key)).getName().equals(name)){
			//System.out.println(customMap.get(key));//�޼ҵ带 void�� �Ҷ� ���/ Ű�� �� Ű�� �ִ� ���� for������ ���
			list.add(customMap.get(key));
		}
	}
	return list;
}

// TODOmileageRange�� ���� ����ȸ
public ArrayList<Customer> findCustomerByMileageRange(int sM, int eM) {
	Set<String> keys = customMap.keySet();//map�� Ű���� set���� ����.
	ArrayList<Customer> list2 = new ArrayList<Customer>();
	for(String key:keys){
		Customer value = customMap.get(key);
		if(sM<value.getMileage() && value.getMileage()<eM){
			//System.out.println(customMap.get(key));//�޼ҵ带 void�� �Ҷ� ���/ Ű�� �� Ű�� �ִ� ���� for������ ���
			list2.add(value);
		}
	}
	return list2;
}

// ������ ����
public void updateCustomerInfo(Customer changeInfo) {
	String id = changeInfo.getId();
	if(!customMap.containsKey(id)){
		System.out.println("�������� �ʴ� ID�Դϴ�. ������ �� �����ϴ�.");
		return ;
	}else{
		customMap.put(id,changeInfo);
		}
	}
	
	
// id�� ���� �� ����
public void removeCustomerById(String id) {
	if(!customMap.containsKey(id)){
		System.out.println("�������� �ʴ� ID�Դϴ�. ������ �� �����ϴ�.");
		return ;
	}else{
		customMap.remove(id);
		}
	}
}
