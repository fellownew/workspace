package bank.server.vo;

public class Account {
	private String accountId;
	private long amount;
	private String type;
	private double interest;
	public Account(String accountId, long amount, String type, double interest) {
		this.accountId = accountId;
		this.amount = amount;
		this.type = type;
		this.interest = interest;
	}
	public String getAccountId() {
		return accountId;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	@Override
	public String toString() {
		return "통장번호 : " + accountId + ", 잔액 : " + amount
				+ ", 종류 : " + type + ", 이자율 : " + interest + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountId == null) ? 0 : accountId.hashCode());
		result = prime * result + (int) (amount ^ (amount >>> 32));
		long temp;
		temp = Double.doubleToLongBits(interest);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Account other = (Account) obj;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		if (amount != other.amount)
			return false;
		if (Double.doubleToLongBits(interest) != Double
				.doubleToLongBits(other.interest))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	//TODO 입,출금,이자율 변경 메소드 필요
}
