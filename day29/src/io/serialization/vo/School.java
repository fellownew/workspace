package io.serialization.vo;

import java.io.Serializable;

public class School implements Serializable{
	private String schoolName,address;
	
	public School(){}
	public School(String schoolName, String address) {
		this.schoolName = schoolName;
		this.address = address;
	}
	
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "학교정보 [학교명=" + schoolName + ", 주소=" + address
				+ "]";
	}
	
}
