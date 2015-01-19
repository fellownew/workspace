package day08.kr.or.kosta.vo;

public class Person {
	private String name, address, hobby;
	private int age,weight,height;
	private boolean merriage;
	
	public Person(){
	}
	public Person(String name, int age, String address){
		this.name = name;
		this.age = age;
		this.address = address;
	}
	public Person(String name, int age, String address, String hobby, int weight, int height, boolean merriage){
		this.name = name;
		this.age = age;
		this.address = address;
		this.hobby = hobby;
		this.weight = weight;
		this.height = height;
		this.merriage = merriage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public boolean isMerriage() {
		return merriage;
	}
	public void setMerriage(boolean merriage) {
		this.merriage = merriage;
	}
	
	public String getDetails(){
		String m = null;
	
		if(merriage){m = "했음";}
		else if(!merriage){m = "안했음";}
		String str = "이름 : "+name+
				"\n나이 : "+age+
				"\n주소 : "+address+
				"\n취미 : "+hobby+
				"\n체중 : "+weight+
				"\n키 : "+height+
				"\n결혼여부 : "+m+
				"\n";
		return str;
	}

	
		

}
