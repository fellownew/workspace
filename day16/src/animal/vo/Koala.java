package animal.vo;

public class Koala extends Animal{

	public Koala() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Koala(String name, int age, double weight, char gender) {
		super(name, age, weight, gender);
		// TODO Auto-generated constructor stub
	}
	public void sleep(){
		System.out.println("ÄÚ¾Ë¶ó°¡ Àá");
	}
	public void eat(){
		System.out.println("Ç®ÀÙ ³È³È");
	}
	@Override
	public String toString() {
		return "Koala [name=" + name + ", age=" + age + ", weight=" + weight
				+ ", gender=" + gender + "]";
	}
	
}
