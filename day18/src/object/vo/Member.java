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

	/*
	 * public boolean equals(Object obj) { if (this == obj) return true; if (obj
	 * == null) return false; if (getClass() != obj.getClass()) return false;
	 * Member other = (Member) obj; if (Id == null) { if (other.Id != null)
	 * return false; } else if (!Id.equals(other.Id)) return false; if (age !=
	 * other.age) return false; if (name == null) { if (other.name != null)
	 * return false; } else if (!name.equals(other.name)) return false; return
	 * true; }
	 */

	// 메소드를 가진 객체(this)와 매개변수로 받은 객체가 같은 객체인지 비교.
	// VO 오버라이딩 : 두개의 객체가 같은 속성값들을 가지면 ture가 반환되도록 오버라이드.
	// ------------------ 속성이 같다는 것은 같은 값을표현하는 것.
	@Override
	public boolean equals(Object obj) {
		// 받은 obj가 member(나와 동일한)객체라면 전체 비교를 시작함.
		if (obj instanceof Member) {
			Member other = (Member) obj;
			// 내 Id, name, age가 받은 obj의 Id, name, age가 동일하다면 true 반환.
			if (other.Id.equals(this.Id) && other.name.equals(this.name)
					&& other.age == this.age) {
				return true;
			}
		}
			return false;
		}
	}
