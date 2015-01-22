package loop.statement;

public class ForTest {
	public static void main(String[] args) {
/*		for (int i = 1; i <= 10; i++) {
			System.out.println(i + "번 안녕하세요");
		}
		
		// 여러 변수 및 조건 가능
		for (int j = 1, k = 10; j <= 10 || k == 0; j++, k--) {
			System.out.println(j + "번 안녕하세요" + k);
		}
*/
		
/*		for (;;) { //조건 생략 = true
			System.out.println("무한 안녕하세요");
		}
*/
		
		//2~9까지 구구단
		for(int i=2;i<10;i++){
			System.out.println("----"+i+"단----");
			for(int j=1;j<10;j++){
				System.out.println(i+"x"+j+"="+(i*j));	
			}
		}
	}
}