package exception.basic;

public class ExceptionTest2 {
	public static void main(String[] args) {
		System.out.println("main ����");
		String str = null;
		// ���� catch
		try {
			str.concat("abc"); // NullPointerException
			int k = 10 / 0; // ArithmethicException

		} catch (NullPointerException e) {
			System.err.println("NullPointerException �߻�");
		} catch (ArithmeticException e) {
			System.err.println("ArithmeticException �߻�");
		}

		System.out.println("main ����");
	}
}
