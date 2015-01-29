package animal.vo;

public class Dog extends Animal{
	public void bark(){
		System.out.println("Â¢´Ù");
	}

	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dog(String name, int age, double weight, char gender) {
		super(name, age, weight, gender);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + ", weight=" + weight
				+ ", gender=" + gender + "]";
	}
	@Override
	public void eat(){
		System.out.println("»ç·á ³È³È");
	}
}
