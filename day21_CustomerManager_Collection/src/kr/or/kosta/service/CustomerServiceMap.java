package kr.or.kosta.service;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

import kr.or.kosta.vo.Customer;

public class CustomerServiceMap {
private TreeMap customMap;

//ID�� Ű�� ����ϴ� map���� ���.

public CustomerServiceMap(){
	customMap=new TreeMap();
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
	Set keys = customMap.keySet();//map�� Ű���� set���� ����.
	for(Object key:keys){
		System.out.println(customMap.get(key));//Ű�� �� Ű�� �ִ� ���� for������ ���
	}
}

// id�� ���� �� ��ȸ
public Customer findCustomerById(String id) {
		return (Customer)customMap.get(id);
	}
	
// name�� ���� �� ��ȸ
public ArrayList findCustomerByName(String name) {
	Set keys = customMap.keySet();//map�� Ű���� set���� ����.
	ArrayList list = new ArrayList();
	for(Object key:keys){
		if(((Customer)customMap.get(key)).getName().equals(name)){
			//System.out.println(customMap.get(key));//�޼ҵ带 void�� �Ҷ� ���/ Ű�� �� Ű�� �ִ� ���� for������ ���
			list.add(customMap.get(key));
		}
	}
	return list;
}

// TODOmileageRange�� ���� ����ȸ
public ArrayList findCustomerByMileageRange(int sM, int eM) {
	Set keys = customMap.keySet();//map�� Ű���� set���� ����.
	ArrayList list2 = new ArrayList();
	for(Object key:keys){
		Customer value = (Customer)customMap.get(key);
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
