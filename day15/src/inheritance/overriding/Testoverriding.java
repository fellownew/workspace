package inheritance.overriding;

public class Testoverriding {
	public static void main(String[] args) {
		Dog d = new Dog();
		d.eat();
		Lion l = new Lion();
		l.eat();
		Animal a1 = new Lion();
		Lion l2 = (Lion) a1;
		a1.eat();
		((Lion) a1).hunt();
		l2.hunt();
	}
}
