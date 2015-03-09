package singleton;
/*
 *  
 * ���ϴ� Ŭ������ (�����Ͻ�, DAO)�� �̱����������� ������.
 */
public class SingletonClass {
	private static SingletonClass inst = new SingletonClass();

	private SingletonClass() {
	}

	public static SingletonClass getInstance() {
		return inst;
	}
}