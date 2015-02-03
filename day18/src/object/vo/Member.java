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

	// �޼ҵ带 ���� ��ü(this)�� �Ű������� ���� ��ü�� ���� ��ü���� ��.
	// VO �������̵� : �ΰ��� ��ü�� ���� �Ӽ������� ������ ture�� ��ȯ�ǵ��� �������̵�.
	// ------------------ �Ӽ��� ���ٴ� ���� ���� ����ǥ���ϴ� ��.
	@Override
	public boolean equals(Object obj) {
		// ���� obj�� member(���� ������)��ü��� ��ü �񱳸� ������.
		if (obj instanceof Member) {
			Member other = (Member) obj;
			// �� Id, name, age�� ���� obj�� Id, name, age�� �����ϴٸ� true ��ȯ.
			if (other.Id.equals(this.Id) && other.name.equals(this.name)
					&& other.age == this.age) {
				return true;
			}
		}
			return false;
		}
	}
