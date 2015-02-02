package object.vo;

public class Member {
	private String Id, name;
	private int age;

	public Member() {
	}

	public Member(String id, String name, int age) {
		Id = id;
		this.name = name;
		this.age = age;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [Id=" + Id + ", name=" + name + ", age=" + age + "]";
	}

}
