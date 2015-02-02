package aggregation;

public class Person {
	private String name;
	private int age;
	private Address address;// preson(whole) has a Address(part) - Aggregation
							        // (Person 객체가 생성되었을때 반드시 Address 객체를 값으로 가지고 있을 필요는 없다.
	
	public Person() {
	}
	
	public Person(String name, int age, Address address) {
										this.name = name;
										this.age = age;
										this.address = address;
									}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
							 

}
