package interfacetest;

public class TestInterface{
	public static void main(String[] args) {
		// interface는 객체 생성이 안됨
		// InterfaceA ia= new InterfaceA();
		// Interface는 하위 클래스들의 타입으로 사용할 수 있다. Type의 역할.
		InterfaceA ia = new SubClassA();
		InterfaceB ib = new SubClassB();

		// SubClassC는 모두 받았으므로 모두 타입이 될 수 있음.
		InterfaceC ic = new SubClassC();
		InterfaceA ic2 = new SubClassC();
		InterfaceB ic3 = new SubClassC();
		// 타입을 이용하는 것이 interface의 주 역할
		ic2.methodA1();
		// ic2.methodB(); //A에 미선언, 에러
		// ic2.methodC(); //A에 미선언, 에러

		ic.methodA1();
		ic.methodA2();
		ic.methodB();
		ic.methodC();

	}

	public static void paintColor(int color) {
		if (color == Color.WHITE) {
			System.out.println("흰색으로 칠한다.");
		} else if (color == Color.BLACK) {
			System.out.println("검정색으로 칠한다.");
		} else if (color == Color.RED) {
			System.out.println("적색으로 칠한다.");
		} else if (color == Color.GREEN) {
			System.out.println("녹색으로 칠한다.");
		} else if (color == Color.BLUE) {
			System.out.println("청색으로 칠한다.");
		} else {
			System.out.println("기본색으로 칠한다.");

		}

	}
}
