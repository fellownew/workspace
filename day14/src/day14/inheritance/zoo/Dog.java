package day14.inheritance.zoo;

public class Dog extends Animal{
	public void bark(){
		System.out.println("Â¢´Ù");
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + ", weight=" + weight
				+ ", gender=" + gender + "]";
	}
}
