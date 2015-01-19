package day08.kr.or.kosta;

import day08.kr.or.kosta.vo.Person;

public class TestPerson {
	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person("홍길동",20,"제주도");
		Person p3 = new Person("임꺽정", 20, "서울시", "도둑질", 70, 180, true);
		System.out.println(p1.getDetails());
		System.out.println(p2.getDetails());
		System.out.println(p3.getDetails());
	
	}
}
