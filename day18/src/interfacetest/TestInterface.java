package interfacetest;

public class TestInterface{
	public static void main(String[] args) {
		// interface�� ��ü ������ �ȵ�
		// InterfaceA ia= new InterfaceA();
		// Interface�� ���� Ŭ�������� Ÿ������ ����� �� �ִ�. Type�� ����.
		InterfaceA ia = new SubClassA();
		InterfaceB ib = new SubClassB();

		// SubClassC�� ��� �޾����Ƿ� ��� Ÿ���� �� �� ����.
		InterfaceC ic = new SubClassC();
		InterfaceA ic2 = new SubClassC();
		InterfaceB ic3 = new SubClassC();
		// Ÿ���� �̿��ϴ� ���� interface�� �� ����
		ic2.methodA1();
		// ic2.methodB(); //A�� �̼���, ����
		// ic2.methodC(); //A�� �̼���, ����

		ic.methodA1();
		ic.methodA2();
		ic.methodB();
		ic.methodC();

	}

	public static void paintColor(int color) {
		if (color == Color.WHITE) {
			System.out.println("������� ĥ�Ѵ�.");
		} else if (color == Color.BLACK) {
			System.out.println("���������� ĥ�Ѵ�.");
		} else if (color == Color.RED) {
			System.out.println("�������� ĥ�Ѵ�.");
		} else if (color == Color.GREEN) {
			System.out.println("������� ĥ�Ѵ�.");
		} else if (color == Color.BLUE) {
			System.out.println("û������ ĥ�Ѵ�.");
		} else {
			System.out.println("�⺻������ ĥ�Ѵ�.");

		}

	}
}
