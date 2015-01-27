package day14.inheritance.zoo;

public class Animal {
	String name;
	int age;
	double weight;
	char gender;
	
	public void eat(){
		System.out.println("³È³È");
	}
	public void sleep(){
		System.out.println("ÄğÄğ");
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
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
}
