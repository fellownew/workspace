package singleton;
/*
 *  
 * 일하는 클래스들 (비지니스, DAO)를 싱글톤패턴으로 구현함.
 */
public class SingletonClass {
	private static SingletonClass inst = new SingletonClass();

	private SingletonClass() {
	}

	public static SingletonClass getInstance() {
		return inst;
	}
}