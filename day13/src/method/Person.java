package method;

public class Person {
	// �Ű������� �ٸ��� �żҵ� �̸��� ���� �̸����� ����� �� �ִ�. - method overloading
	// ���� ���� �ϴ� ��� ���� �ϴ°��� ����.
	public void go() {
		System.out.println("����");
	}

	public void go(int i) {
		System.out.println(i + "��ŭ ����");
	}

	public void go(String s) {
		System.out.println(s + "���� ����");
	}
}
