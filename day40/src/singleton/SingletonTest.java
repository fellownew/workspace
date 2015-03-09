package singleton;

public class SingletonTest {
	public static void main(String[] args) {
//		SingletonClass c1 = new SingletonClass();
//		SingletonClass c2 = new SingletonClass();
//		System.out.println(c1==c2);
		SingletonClass c3 = SingletonClass.getInstance();
		SingletonClass c4 = SingletonClass.getInstance();
		System.out.println(c3==c4);
		
	}
}
