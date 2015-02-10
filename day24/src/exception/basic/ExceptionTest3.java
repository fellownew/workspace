package exception.basic;

public class ExceptionTest3 {
	public static void main(String[] args) {
		String str = null;
		//상위인 Exception으로 한번에 잡기
		try{
			str.concat("abc"); // NullPointerException
			int k = 10 / 0; // ArithmethicException
		}catch(Exception e){//Exception들의 상위 타입이므로 catch를 지정해도 예외 처리가 가능함.
			System.err.println("예외 발생");
		}
	}
}
