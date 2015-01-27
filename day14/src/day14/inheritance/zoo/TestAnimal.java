package day14.inheritance.zoo;

public class TestAnimal {
	public static void main(String[] args) {
		Lion l1 = new Lion();
		l1.setAge(15);
		System.out.println(l1.getAge());
		l1.sleep();
		Dog d1 = new Dog();
		d1.setName("¸»¶ó¹ÂÆ®");
		d1.setAge(1);
		d1.setGender('¡Ï');
		d1.bark();
		System.out.println(d1.toString());
	}
}
