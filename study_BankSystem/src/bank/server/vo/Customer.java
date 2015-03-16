package bank.server.vo;

import java.util.ArrayList;

public class Customer {
	private String customerId,customerPassword,customerName;
	private ArrayList<Account> customerAccount;
	private int creditRating; //신용등급
	private String job;
	private int age;
	private boolean sex;
	private String phoneNumber,adress;
	public Customer(String customerId, String customerPassword,
			String customerName, ArrayList<Account> customerAccount,
			int creditRating, String job, int age, boolean sex,
			String phoneNumber, String adress) {
		this.customerId = customerId;
		this.customerPassword = customerPassword;
		this.customerName = customerName;
		this.customerAccount = customerAccount;
		this.creditRating = creditRating;
		this.job = job;
		this.age = age;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.adress = adress;
	}
	public int getCreditRating() {
		return creditRating;
	}
	public void setCreditRating(int creditRating) {
		this.creditRating = creditRating;
	}
	public String getCustomerId() {
		return customerId;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public String getCustomerName() {
		return customerName;
	}
	public ArrayList<Account> getCustomerAccount() {
		return customerAccount;
	}
	public String getJob() {
		return job;
	}
	public int getAge() {
		return age;
	}
	public boolean isSex() {
		return sex;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getAdress() {
		return adress;
	}
	@Override
	public String toString() {
		return "고객ID : " + customerId + ", 고객 이름 : " + customerName
				+ ", 보유통장 : " + customerAccount + ", 신용 등급 : "
				+ creditRating + ", 직업 : " + job + ", 나이 : " + age + ",  성별 : "
				+ sex + ", 전화번호 : " + phoneNumber + ", 주소 : " + adress;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + age;
		result = prime * result + creditRating;
		result = prime * result
				+ ((customerAccount == null) ? 0 : customerAccount.hashCode());
		result = prime * result
				+ ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result
				+ ((customerName == null) ? 0 : customerName.hashCode());
		result = prime
				* result
				+ ((customerPassword == null) ? 0 : customerPassword.hashCode());
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		result = prime * result
				+ ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + (sex ? 1231 : 1237);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (age != other.age)
			return false;
		if (creditRating != other.creditRating)
			return false;
		if (customerAccount == null) {
			if (other.customerAccount != null)
				return false;
		} else if (!customerAccount.equals(other.customerAccount))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (customerPassword == null) {
			if (other.customerPassword != null)
				return false;
		} else if (!customerPassword.equals(other.customerPassword))
			return false;
		if (job == null) {
			if (other.job != null)
				return false;
		} else if (!job.equals(other.job))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (sex != other.sex)
			return false;
		return true;
	}
	
}
