package kr.or.kosta.service;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

import kr.or.kosta.vo.Customer;

public class CustomerServiceMap {
private TreeMap customMap;

//ID를 키로 사용하는 map으로 사용.

public CustomerServiceMap(){
	customMap=new TreeMap();
}

// 고객 가입, 중복ID 미허용
public void registerCustomer(Customer customer) {
	String s1 = customer.getId();
	if(customMap.containsKey(s1)){
		System.out.println("이미 등록된 ID 입니다.");
		return;
	}
	customMap.put(s1,customer);
}

// 고객리스트 출력
public void printCustomerList() {
	Set keys = customMap.keySet();//map의 키들을 set으로 복사.
	for(Object key:keys){
		System.out.println(customMap.get(key));//키와 그 키에 있는 값을 for문으로 출력
	}
}

// id에 의한 고객 조회
public Customer findCustomerById(String id) {
		return (Customer)customMap.get(id);
	}
	
// name에 의한 고객 조회
public ArrayList findCustomerByName(String name) {
	Set keys = customMap.keySet();//map의 키들을 set으로 복사.
	ArrayList list = new ArrayList();
	for(Object key:keys){
		if(((Customer)customMap.get(key)).getName().equals(name)){
			//System.out.println(customMap.get(key));//메소드를 void로 할때 사용/ 키와 그 키에 있는 값을 for문으로 출력
			list.add(customMap.get(key));
		}
	}
	return list;
}

// TODOmileageRange에 의한 고객조회
public ArrayList findCustomerByMileageRange(int sM, int eM) {
	Set keys = customMap.keySet();//map의 키들을 set으로 복사.
	ArrayList list2 = new ArrayList();
	for(Object key:keys){
		Customer value = (Customer)customMap.get(key);
		if(sM<value.getMileage() && value.getMileage()<eM){
			//System.out.println(customMap.get(key));//메소드를 void로 할때 사용/ 키와 그 키에 있는 값을 for문으로 출력
			list2.add(value);
		}
	}
	return list2;
}

// 고객정보 변경
public void updateCustomerInfo(Customer changeInfo) {
	String id = changeInfo.getId();
	if(!customMap.containsKey(id)){
		System.out.println("존재하지 않는 ID입니다. 수정할 수 없습니다.");
		return ;
	}else{
		customMap.put(id,changeInfo);
		}
	}
	
	
// id에 의한 고객 삭제
public void removeCustomerById(String id) {
	if(!customMap.containsKey(id)){
		System.out.println("존재하지 않는 ID입니다. 삭제할 수 없습니다.");
		return ;
	}else{
		customMap.remove(id);
		}
	}
}
