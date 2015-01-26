package day13.aggregation;

public class TestAggregation {
	public static void main(String[] args) {
		Address address = new Address("111-111", "¼­¿ï½Ã");
		Person p1 = new Person();
		System.out.println(p1.getAddress());
		p1.setAddress(address);
		System.out.println(p1.getAddress().getAddressDetails());
	}
}
