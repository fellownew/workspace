package primitive.typecasting;

public class TypeCastingTest {
	public static void main(String[] args) {
			//upcasting : 작은 타입 -> 큰 타입 : 자동으로 일어남 (알아서 해줌)
	//	double a = 10+10.9; //int + double : int를 double로 변형 후 덧셈 
	//	boolean b = 10 >'A'; // 비교연산 int>char 
	//	long c = 20; // 변수 = 값 int(20) -> long(20)
		
		 //downcasting 큰 타입 -> 작은 타입 : 형변환 연산자를 이용해야함. 값이 깨질 가능성이 있음
		// 변수 = 값, 변수의 타입보다 값의 타입이 더 큰 경우에 자주 사용됨.
	//	int i =(int)200l;
		int i2 = (int)3000000000l;
		System.out.println(i2);
		
	}
}
