package inheritance.zoo;

public class Lion extends Animal{
	String habitat;
	
	public void hunt(){
		System.out.println("»ç³É");
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

}
