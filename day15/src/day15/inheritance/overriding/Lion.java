package day15.inheritance.overriding;

public class Lion extends Animal{
	String habitat;
	
	public void hunt(){
		System.out.println("����ϴ�");
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
		System.out.println("��Ƽ� �ȳ�");
	}

}
