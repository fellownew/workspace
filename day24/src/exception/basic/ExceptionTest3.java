package exception.basic;

public class ExceptionTest3 {
	public static void main(String[] args) {
		String str = null;
		//������ Exception���� �ѹ��� ���
		try{
			str.concat("abc"); // NullPointerException
			int k = 10 / 0; // ArithmethicException
		}catch(Exception e){//Exception���� ���� Ÿ���̹Ƿ� catch�� �����ص� ���� ó���� ������.
			System.err.println("���� �߻�");
		}
	}
}
