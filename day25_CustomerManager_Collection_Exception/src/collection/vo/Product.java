package collection.vo;

import java.io.Serializable;
//정렬 가능한 타입의 클래스로 
//implements Comparable<E>를 받은 후 public int compareTo(E e)를 오버라이딩(this와 e를 비교)
public class Product implements Serializable,Comparable<Product> {
	private String productId, productName, productMaker;
	private int price;

	public Product() {
	}

	public Product(String productId, String productName, String productMaker,
			int price) {
		this.productId = productId;
		this.productName = productName;
		this.productMaker = productMaker;
		this.price = price;
	}
	//정렬을 위한 compareTo 오버라이드
	@Override
	public int compareTo(Product p){
		//this와 p를 비교하여 같으면 0, this가크면 양수, this가 작으면 음수
		//this 비교 p-> 오름차순, 반대는 내림차순
		
		return this.getProductId().compareTo(p.productId); //ID String 비교
//		return this.getProductName().compareTo(p.getProductName()); //제품이름 기준 비교.
//		return this.price - p.price; //int값으로 할땐 이런 방법도 가능. 양수,음수만을 따지기때문에 가능.
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductMaker() {
		return productMaker;
	}

	public void setProductMaker(String productMaker) {
		this.productMaker = productMaker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName="
				+ productName + ", productMaker=" + productMaker + ", price="
				+ price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + price;
		result = prime * result
				+ ((productId == null) ? 0 : productId.hashCode());
		result = prime * result
				+ ((productMaker == null) ? 0 : productMaker.hashCode());
		result = prime * result
				+ ((productName == null) ? 0 : productName.hashCode());
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
		Product other = (Product) obj;
		if (price != other.price)
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productMaker == null) {
			if (other.productMaker != null)
				return false;
		} else if (!productMaker.equals(other.productMaker))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		return true;
	}

}
