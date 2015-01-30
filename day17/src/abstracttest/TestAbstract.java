package abstracttest;

public class TestAbstract {
public static void main(String[] args) {
//	 SuperClass sc = new SuperClass(); 추상클래스이기때문에 객체생성이 불가함.
	
	SubClass sc1 = new SubClass();
	sc1.abstractMethod(); //SubClass에서 overriding
	sc1.templateMethod();//SuperClass에서 구현
}
}
