package generics;

public class GenericsTest {
	public static void main(String[] args) {
		MyClass2<String> mc2 = new MyClass2<String>();
		mc2.go("asdfasdf");
//		mc2.come(20);  String Ÿ������ �����߱� ������ �ٸ� Ÿ���� ������ ����
		MyClass2<Integer> mc3 = new MyClass2<Integer>();
		mc3.go(20);
		mc3.come(50);
//		mc3.come("asdf"); �ȵ�.
		MyClass3<Dog> mc4 = new MyClass3<Dog>();
//		MyClass3<String> mc5 = new MyClass3<String>(); �ȵ�
		MyClass2 mc6 = new MyClass2();//����Ÿ���� ������ �ʾƼ� T�� Object�� ��.
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
class MyClass3<T extends Animal> {//����Ÿ���� Ư�� Ÿ������ �����ϱ�. Animal Type(���� ����)�� ������.

}
