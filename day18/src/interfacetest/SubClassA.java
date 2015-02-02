package interfacetest;

public class SubClassA implements InterfaceA {
	// interface에 선언된 추상 메소드 overriding 해야함. or abstract 클래스로 선언.

	@Override
	// annotation - system(compiler,jvm)에게 알려주는 주석
	public void methodA1() {
		System.out.println("SubCalssA.methodA1()");
	}

	@Override
	public void methodA2() {
		System.out.println("SubCalssA.methodA2()");
	}

}
