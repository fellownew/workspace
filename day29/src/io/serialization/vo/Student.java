package io.serialization.vo;

import java.io.Serializable;

public class Student implements Serializable{
	private String studentNo,name;
	private transient int grade;
	private int clazz;
	private School school;
	
	public Student(){}
	public Student(String studentNo, String name, int grade, int clazz) {
		this.studentNo = studentNo;
		this.name = name;
		this.grade = grade;
		this.clazz = clazz;
	}
	
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClazz() {
		return clazz;
	}
	public void setClazz(int clazz) {
		this.clazz = clazz;
	}
	@Override
	public String toString() {
		return "학생정보 [번호=" + studentNo + ", 이름=" + name
				+ ", 학년=" + grade + ", 반=" + clazz + ", "
				+ school + "]";
	}
}