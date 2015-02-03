package objecttest;

public class Compare1 {
	String name,address;
	int age;
	public Compare1(){}
	public Compare1(String name, String address, int age) {
		this.name = name;
		this.address = address;
		this.age = age;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//address�� null�̶�� 0, �ƴϸ� address�� hashcode�� ��ȯ
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		//���� obj�� �ڽ��̶�� true
		if (this == obj)
			return true;
		//���� obj�� null���̶�� false
		if (obj == null)
			return false;
		//�ٸ� ��ü��� false
		if (getClass() != obj.getClass())
			return false;
		//obj�� ���� Ÿ������ ����ȯ
		Compare1 other = (Compare1) obj;
		
		if (address == null) { // address�� null �̶�� 
			if (other.address != null)//�׷��� ���� obj�� address�� null�� �ƴϸ� false
				return false;
		} else if (!address.equals(other.address))//object�� equal�� �������� ���� �ٸ��� false
			return false;
		
		if (age != other.age)//age�� ���� �ٸ��� false
			return false;
		
		if (name == null) {// address�� ����
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		
		return true;
	}
}
