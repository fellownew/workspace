package stockmarket.vo;

import java.util.Hashtable;


public class HaveStock {
	Hashtable<Stock, Integer> haveStock;

	public HaveStock(Hashtable<Stock, Integer> haveStock) {
		this.haveStock = haveStock;
	}

	public Hashtable<Stock, Integer> getHaveStock() {
		return haveStock;
	}

	public void setHaveStock(Hashtable<Stock, Integer> haveStock) {
		this.haveStock = haveStock;
	}

	@Override
	public String toString() {
		return "HaveStock [haveStock=" + haveStock + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((haveStock == null) ? 0 : haveStock.hashCode());
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
		if (haveStock == null) {
			if (other.haveStock != null)
				return false;
		} else if (!haveStock.equals(other.haveStock))
			return false;
		return true;
	}
	
	
}
