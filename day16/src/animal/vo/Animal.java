package animal.vo;

public class Animal {
	String name;
	int age;
	double weight;
	char gender;
	public Animal(){}
	public Animal(String name, int age, double weight, char gender) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.gender = gender;
	}
	public void eat(){
		System.out.println("¸Ô´Ù");
	}
	public void sleep(){
		System.out.println("ÄðÄð");
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
