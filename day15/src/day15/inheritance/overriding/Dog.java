package day15.inheritance.overriding;

public class Dog extends Animal{
	public void bark(){
		System.out.println("¢��");
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + ", weight=" + weight
				+ ", gender=" + gender + "]";
	}
	@Override
	public void eat(){
		System.out.println("��� �ȳ�");
	}
}
