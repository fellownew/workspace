package io.charstream;

import java.io.IOException;
import java.io.PrintWriter;

public class Printf_Test {
/*
 * PrintWriter, PrintStream에 있는 println(), print(), printf()중에
 * printf()는 jdk1.5에 추가된 것으로 printf(String format, Object... args)이다. 
 * format에 써주는 패턴으로 전환문자를 이용하여 패턴화하여 전달해주며
 * args는 가변인자로 전환문자에 들어갈 값을 순서대로 사용한다.
 * format에서 사용할 주요 전환 문자는 %문자로 사용된다.
 * %d:10진수(정수), %f:실수, %s:문자 %n(or)\n:엔터, %t(or)\t:탭, %% : %
 * 전환문자를 제외한 문자는 해당 자리에 그대로 출력.
 * 이중 %f는 (#.000000)패턴처럼 소수점6자리까지 출력하며 %.3f 처럼 점.숫자를 표기하면 소수점이하3자리(#.000)까지 표현함.
*/
	
	public static void main(String[] args) throws IOException {
		Printf_Test pt = new Printf_Test();
		pt.printfTest();
		String name = "홍길동";
		int a=16,b=64,c=128,d=512;
		System.out.printf("%s가 계산해봤더니 %d와 %d와 %d와 %d를 모두 더하면 %d이다.%n",name,a,b,c,d,a+b+c+d);
		double weight =75.5,height=177.6;
		System.out.printf("%s의 몸무게는 %.2fkg, 키는 %.2fcm이다.%n",name,weight,height);
	}
	
	public void printfTest() throws IOException{
		PrintWriter pw = null;
		int num=2,dis=363;
		String name="홍길동",des="제주도";
		try{
			pw = new PrintWriter("C:\\JAVA\\printtest.txt");
			pw.printf("총 일행이 %d명인 %s파티가 %dKm만큼 이동하여 %s에 놀러갔다. %n",num,name,dis,des);
			
		}finally{
			if(pw!=null)pw.close();
		}
		System.out.println("파일생성완료");
	}
}
