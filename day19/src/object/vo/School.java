package object.vo;

public class School {
	String name, address;
	int schoolNo;

	public School() {
	}

	public School(String name, String address, int schoolNo) {
		this.name = name;
		this.address = address;
		this.schoolNo = schoolNo;
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

	public int getSchoolNo() {
		return schoolNo;
	}

	public void setSchoolNo(int schoolNo) {
		this.schoolNo = schoolNo;
	}

	@Override
	public String toString() {
		return "School [name=" + name + ", address=" + address + ", schoolNo="
				+ schoolNo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + schoolNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		School other = (School) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (schoolNo != other.schoolNo)
			return false;
		return true;
	}

}
