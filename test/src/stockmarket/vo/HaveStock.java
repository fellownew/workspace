package stockmarket.vo;

public class HaveStock {
	private Stock stock;
	private int number;
	
	public HaveStock(Stock stock, int number) {
		this.stock = stock;
		this.number = number;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
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
		HaveStock other = (HaveStock) obj;
		if (number != other.number)
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		return true;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "HaveStock [stock=" + stock + ", number=" + number + "]";
	}
}
