package exception.basic;

public class ExceptionTest1 {
	public static void main(String[] args) {
		
		try{ //예외 발생 가능성이 있는 구문
			System.out.println("main start");
			String str = null;
			String str2 = str.concat("abc");
			System.out.println(str2);
		}catch(NullPointerException e){//발생한 예외에 대한 처리 구문
			System.err.println(e+" 발생");
			
		}
		System.out.println("main 종료");	
	}
}
