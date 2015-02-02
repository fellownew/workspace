package aggregation;

public class Address {
	private String zipcode, address;

	// no-args constructor
	public Address() { //no-args �����ڷ� compostion�� �ƴ� aggregation ���谡 ��.
	}
	//all-args constructor
	public Address(String zipcode, String address) {
		this.zipcode = zipcode;
		this.address = address;
	}

	// setter, getter
	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressDetails() {
		return "�����ȣ : " + zipcode + "�� �ּ� : " + address;
	}

}// end
