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
		System.out.println("�ھ˶� ��");
	}
	public void eat(){
		System.out.println("Ǯ�� �ȳ�");
	}
	@Override
	public String toString() {
		return "Koala [name=" + name + ", age=" + age + ", weight=" + weight
				+ ", gender=" + gender + "]";
	}
	
}
