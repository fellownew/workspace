package day08.kr.or.kosta.vo;

public class Person2 {
	private String name, address, hobby;
	private int age;
	private double weight, height;
	private boolean merriage;

	public Person2(String name, String address, String hobby, int age,
			double weight, double height, boolean merriage) {
		super();
		this.name = name;
		this.address = address;
		this.hobby = hobby;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.merriage = merriage;
	}

	public Person2(String name, String address, int age) {
		this.name = name;
		this.address = address;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public boolean isMerriage() {
		return merriage;
	}

	public void setMerriage(boolean merriage) {
		this.merriage = merriage;
	}

	@Override
	public String toString() {
		return "Person2 [name=" + name + ", address=" + address + ", hobby="
				+ hobby + ", age=" + age + ", weight=" + weight + ", height="
				+ height + ", merriage=" + merriage + "]";
	}

}
