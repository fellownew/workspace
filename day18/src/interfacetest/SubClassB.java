package interfacetest;
//클래스는 여러개의 interface를 implements 할 수 있다. 
public class SubClassB implements InterfaceA, InterfaceB{

	@Override
	public void methodB() {
		System.out.println("SubCalssB.methodB()");		
	}

	@Override
	public void methodA1() {
		System.out.println("SubCalssB.methodA1()");				
	}

	@Override
	public void methodA2() {
		System.out.println("SubCalssB.methodA2()");				
	}
	

}
