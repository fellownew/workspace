package bank.server.vo;

public class Type {
	private String typeName;
	private double interest;
	public Type(String typeName, double interest) {
		this.typeName = typeName;
		this.interest = interest;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(interest);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((typeName == null) ? 0 : typeName.hashCode());
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
		Type other = (Type) obj;
		if (Double.doubleToLongBits(interest) != Double
				.doubleToLongBits(other.interest))
			return false;
		if (typeName == null) {
			if (other.typeName != null)
				return false;
		} else if (!typeName.equals(other.typeName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "상품명 : " + typeName + ", 금리 : " + interest;
	}
	
}
