package interfacetest;
//Ŭ������ �������� interface�� implements �� �� �ִ�. 
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
