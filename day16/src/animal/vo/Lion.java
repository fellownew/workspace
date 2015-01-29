package animal.vo;

public class Lion extends Animal{
	String habitat;
	
	public Lion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Lion(String name, int age, double weight, char gender,String habitat) {
		super(name, age, weight, gender);
		// TODO Auto-generated constructor stub
		this.habitat=habitat;
	}

	public void hunt(){
		System.out.println("ªÁ≥…«œ¥Ÿ");
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	@Override
	public String toString() {
		return "Lion [habitat=" + habitat + ", name=" + name + ", age=" + age
				+ ", weight=" + weight + ", gender=" + gender + "]";
	}
	@Override
	public void eat(){
		System.out.println("¿‚æ∆º≠ ≥»≥»");
	}

}
