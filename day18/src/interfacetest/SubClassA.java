package interfacetest;

public class SubClassA implements InterfaceA {
	// interface�� ����� �߻� �޼ҵ� overriding �ؾ���. or abstract Ŭ������ ����.

	@Override
	// annotation - system(compiler,jvm)���� �˷��ִ� �ּ�
	public void methodA1() {
		System.out.println("SubCalssA.methodA1()");
	}

	@Override
	public void methodA2() {
		System.out.println("SubCalssA.methodA2()");
	}

}
