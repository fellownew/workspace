package abstracttest;

public class TestAbstract {
public static void main(String[] args) {
//	 SuperClass sc = new SuperClass(); �߻�Ŭ�����̱⶧���� ��ü������ �Ұ���.
	
	SubClass sc1 = new SubClass();
	sc1.abstractMethod(); //SubClass���� overriding
	sc1.templateMethod();//SuperClass���� ����
}
}
