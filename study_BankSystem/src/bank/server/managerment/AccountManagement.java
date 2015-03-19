package bank.server.managerment;

import java.util.ArrayList;

import bank.server.vo.Account;
import bank.server.vo.Type;

public class AccountManagement {
	private static AccountManagement inst = new AccountManagement();
	private ArrayList<Account> accountList;
	private ArrayList<Type> typeList;
	private AccountManagement(){}
	public static AccountManagement getInstance(){
		return inst;
	}
	public void addAccount(String id,long amount,Type type,double interest) {
		accountList.add(new Account(id,amount,type,interest));
	}
	
	public void removeAccount(String id){
		int index;
		for(index=0;index<accountList.size();index++){
			if(accountList.get(index).getAccountId().equals(id)){//리스트들중 매개변수로 받은 아이디와 동일 아이디가 있으면 삭제
				accountList.remove(index);
				break;
			}
		}
		
	}
	public void setAccount(){
		
	}

	public void addType(String typeName,double interest){
		typeList.add(new Type(typeName,interest));
	}
	public void removeType(){
		
	}
	public void setType(Type type){
		
	}
}
