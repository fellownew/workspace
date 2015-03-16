package bank.server.vo;

public class Bank {
	private long amount;

	public Bank(long amount) {
		//TODO DB로부터 현재 값 불러오기.
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "은행 금고 : " + amount;
	}

	public long getAmount() {
		return amount;
	}

	public void reduceAmount(int money) {
		amount -=money;;
	}
	
	public void addAmount(int money){
		amount += money;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (amount ^ (amount >>> 32));
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
		Bank other = (Bank) obj;
		if (amount != other.amount)
			return false;
		return true;
	}
	
	
	
}
