package branch.statement;

public class IfTest {
	public static void main(String[] args) {
		int x = 100;
		/*
		 * 조건문 if 
		 * if(조건){ 실행코드
		 * }else{실행코드
		 * }
		 */

		if (x < 0) {
			System.out.println("음수");
		} else if (x == 0) {
			System.out.println("0");
		} else {
			System.out.println("양수");
		}
		String city ="서울"; // String값의 동등비교는 ==가 적절치 않다.
		if(city.equals("서울")){
			System.out.println("한국의 수도");
		}else if(city.equals("베이징")){
			System.out.println("중국의 수도");
		}else if(city.equals("도쿄")){
			System.out.println("일본의 수도");
		}
		
		
	}
}
