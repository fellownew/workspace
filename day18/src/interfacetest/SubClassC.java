package interfacetest;

public class SubClassC implements InterfaceC{
	//interfaceC�� A,B�� ��� ��� �ް� �����Ƿ� interfaceC�� ���� SubclassC�� ��� �޼ҵ带 �������̵� �ؾ���.
	@Override
	public void methodB() {
		System.out.println("SubCalssC.methodB()");				
	}

	@Override
	public void methodA1() {
		System.out.println("SubCalssC.methodA1()");		
		
	}

	@Override
	public void methodA2() {
		System.out.println("SubCalssC.methodA2()");				
	}

	@Override
	public void methodC() {
		System.out.println("SubCalssC.methodC()");				
	}

}
