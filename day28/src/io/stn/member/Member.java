package io.stn.member;

public class Member {
	private String name;
	private int age;
	private String telNo;

	public Member() {
	}

	public Member(String name, int age, String telNo) {
		this.name = name;
		this.age = age;
		this.telNo = telNo;
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

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	@Override
	public String toString() {
		return "회원정보 [이름=" + name + ", 나이=" + age + ", 전화번호=" + telNo + "]";
	}

}
