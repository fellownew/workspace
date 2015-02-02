package method;

public class Person {
	// 매개변수가 다르면 매소드 이름은 같은 이름으로 사용할 수 있다. - method overloading
	// 같은 일을 하는 경우 적용 하는것이 좋다.
	public void go() {
		System.out.println("간다");
	}

	public void go(int i) {
		System.out.println(i + "만큼 간다");
	}

	public void go(String s) {
		System.out.println(s + "까지 간다");
	}
}
