package interfacetest;

public class SubClassC implements InterfaceC{
	//interfaceC가 A,B를 모두 상속 받고 있으므로 interfaceC를 받은 SubclassC는 모든 메소드를 오버라이드 해야함.
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
