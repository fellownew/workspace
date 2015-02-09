package generics;

public class GenericsTest {
	public static void main(String[] args) {
		MyClass2<String> mc2 = new MyClass2<String>();
		mc2.go("asdfasdf");
//		mc2.come(20);  String 타입으로 지정했기 때문에 다른 타입은 컴파일 에러
		MyClass2<Integer> mc3 = new MyClass2<Integer>();
		mc3.go(20);
		mc3.come(50);
//		mc3.come("asdf"); 안됨.
		MyClass3<Dog> mc4 = new MyClass3<Dog>();
//		MyClass3<String> mc5 = new MyClass3<String>(); 안됨
		MyClass2 mc6 = new MyClass2();//가변타입을 정하지 않아서 T는 Object가 됨.
	}
}

class Animal{}
class Dog extends Animal{}
class Cat extends Animal{}


class MyClass {
	public void go(Object o) {

	}

	public void come(Object o) {

	}
}

class MyClass2<T> {
	public void go(T t) {

	}

	public void come(T t) {

	}
}
class MyClass3<T extends Animal> {//가변타입을 특정 타입으로 한정하기. Animal Type(하위 포함)만 가능함.

}
