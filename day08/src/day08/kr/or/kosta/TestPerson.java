package day08.kr.or.kosta;

import day08.kr.or.kosta.vo.Person;

public class TestPerson {
	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person("ȫ�浿",20,"���ֵ�");
		Person p3 = new Person("�Ӳ���", 20, "�����", "������", 70, 180, true);
		System.out.println(p1.getDetails());
		System.out.println(p2.getDetails());
		System.out.println(p3.getDetails());
	
	}
}
