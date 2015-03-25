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
	
	public ArrayList<Account> findAccount(String accountId){
		ArrayList<Account> accTempList=null;
			for(Account ac :accountList){
				//ã��
			}
		return accTempList;
	}
	
	public void addAccount(String id,long amount,Type type,double interest) {
		accountList.add(new Account(id,amount,type));
	}
	
	public void removeAccount(String id){
		int index;
		for(index=0;index<accountList.size();index++){
			if(accountList.get(index).getAccountId().equals(id)){//����Ʈ���� �Ű������� ���� ���̵�� ���� ���̵� ������ ����
				accountList.remove(index);
				break;
			}
		}
	}
	public void setAccount(String id, long amount){
		for(int index=0;index<accountList.size();index++){
			if(accountList.get(index).getAccountId().equals(id)){
				accountList.get(index).setAmount(accountList.get(index).getAmount()+amount);
			}
		}
	}

	public void addType(String typeName,double interest){
		typeList.add(new Type(typeName,interest));
	}
	
	public void removeType(Type type){
		for(int index=0;index<typeList.size();index++){
			if(type.getTypeName().equals(typeList.get(index).getTypeName())){
				typeList.remove(index);
			}
		}
	}
	
	public void setType(Type type){
		for(int index=0;index<typeList.size();index++){
			if(type.getTypeName().equals(typeList.get(index).getTypeName())){
				typeList.set(index, type);
			}
		}
	}
}
