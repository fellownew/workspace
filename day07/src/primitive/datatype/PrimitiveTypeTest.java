package primitive.datatype;

public class PrimitiveTypeTest {
	public static void main(String[] args) {
		// 정수형 : byte < short < int < long
		// int var1 = 10;
		// long var2 = 10l;
		// long var3 = 10L;
		// byte var4 = 10; // byte, short은 범위에만 맞으면 됨. 따로 표시하는 방법이 없음.
		// byte var5 = 22333;
		// long var6 = 700000000000l; // 정수의 값이 int를 넘어서면 L을 붙여야 함.
		int var7 = 010; // 8진수
		System.out.println(var7);
		int var8 = 0x20AF; // 16진수
		System.out.println(var8);
		int var9 = 3425 * 3545 * 3215 * 3245 * 235 * 344 * 398 * 393 * 359
				* 993;
		System.out.println(var9);
		long var10 = 3425l * 3545 * 3215 * 3245 * 235 * 344 * 398 * 393 * 359
				* 993;
		System.out.println(var10);

		// 실수형 : float(소수점이하7자리), < double(소수점 이하 16자리) - 정밀도
		// float f1 = 30.5f;
		// float f2 = 30f;
		// double d1 = 304209384.34355;
		// double d2 = 234234d;
		// 실수형 값은 계산에 사용하지 않는 것이 좋음. -> BigDecimal 클래스 이용하여 계산
		double d4 = 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1;
		System.out.println(d4);

		// 문자 : cahr - 유니코드 한 문자, 값' ' 으로 감쌈.
		char c1 = 1010;
		char c2 = '쀏';
		char c3 = '\uC012';
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		// char c6 = '\'';
		char c7 = '\\';
		System.out.println(c7);
		String str1 = "Hi hello"; // 기본타입이 아닌 reference 타입
		System.out.println(str1);
		String str2 = "a\tb\tc\td\te\t\nf";
		System.out.println(str2);
		String str3 = "c:\\temp\\source\\a.txt";
		System.out.println(str3);
		// String str4 = "안녕하세요"+"asdlkfjalsdkf"+str2;
		// String은 모든 타입을 다 사용이 가능하며 모두 String타입으로 만든다.

		// 논리형 = boolean : 값 : true / false
		boolean b1 = true;
		boolean b2 = false;
		System.out.println(b1 + "," + b2);

	}
}
