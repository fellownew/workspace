package abstracttest;

//부모클래스가 abstract 클래스일경우 abstract로 선언 하거나 메소드를 오버라이딩 해야함.
public class SubClass extends SuperClass{
	
	
	@Override
	public void abstractMethod(){
		System.out.println("오버라이딩 된 abstractMethod");
	}
	

}
