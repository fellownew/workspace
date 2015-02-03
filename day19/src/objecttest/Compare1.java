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
		//address가 null이라면 0, 아니면 address의 hashcode를 반환
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		//받은 obj가 자신이라면 true
		if (this == obj)
			return true;
		//받은 obj가 null값이라면 false
		if (obj == null)
			return false;
		//다른 객체라면 false
		if (getClass() != obj.getClass())
			return false;
		//obj를 같은 타입으로 형변환
		Compare1 other = (Compare1) obj;
		
		if (address == null) { // address가 null 이라면 
			if (other.address != null)//그런데 받은 obj의 address가 null이 아니면 false
				return false;
		} else if (!address.equals(other.address))//object의 equal로 비교했을때 서로 다르면 false
			return false;
		
		if (age != other.age)//age가 서로 다르며 false
			return false;
		
		if (name == null) {// address와 동일
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		
		return true;
	}
}
