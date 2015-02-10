package exception.basic;

public class ExceptionTest2 {
	public static void main(String[] args) {
		System.out.println("main 시작");
		String str = null;
		// 다중 catch
		try {
			str.concat("abc"); // NullPointerException
			int k = 10 / 0; // ArithmethicException

		} catch (NullPointerException e) {
			System.err.println("NullPointerException 발생");
		} catch (ArithmeticException e) {
			System.err.println("ArithmeticException 발생");
		}

		System.out.println("main 종료");
	}
}
