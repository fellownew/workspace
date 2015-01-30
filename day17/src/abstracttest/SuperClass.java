package abstracttest;
//abstract 메소도를 가진 클래스는 반드시 abstract 클래스로 선언해야함. -> 객체 생성 불가 클래스
public abstract class SuperClass {

		public abstract void abstractMethod();
		
		//추상 클래스는 구현된 메소드, instance/static 변수, 생성자 모두 가질 수 있다.
		//구현된 메소드 - 자식클래스들에 공통적으로 구현한 메소드.
		public void templateMethod(){
			System.out.println("SuperClass-templateMethod");
		}
		
/*		추상 클래스
		추상 메소드(abstract 메소드) : 하위클래스마다 구현이 다른경우, 선언구문은 추상클래스에서 정의, 구현은 하위에서 알맞게 함.
		구현된 메소드(Template 메소드) : 하위 클래스들이 공통적인 구현을 가지는 경우 부모에 정의하고 상속받아 사용.*/
		
}
