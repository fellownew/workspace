package charsequence.test;
public class StringTest_template {
	public static void main(String[] args) {
		String s1 = "abcde";
		String s2 = new String("abcde");
		String s3 = "ABCDE";

		int strLength = s1.length();// 글자수 조회
		System.out.println(strLength);// 글자수

		System.out.println("s1 == s2 : "+(s1 == s2)); //s1과 s2의 비교
		System.out.println("s1.equals(s2) : "+s1.equals(s2)); //s1과 s2를 equals로 비교
		System.out.println("s1.equals(s3) : "+s1.equals(s3)); //s1과 s3를 equals로 비교
		
		System.out.println("s1.equalsIgnoreCase(s3) : "+s1.equalsIgnoreCase(s3)); //s1과 s3의 대소문자 무시 비교
		
		boolean flag = s1.startsWith("ab"); // s1 앞부분이 ab로 시작하는가?
		System.out.println("s1.startsWith(\"ab\") : "+flag);
		System.out.println("s1.endsWith(\"ef\") : "+s1.endsWith("ef")); // s1의 마지막 부분이 ef로 끝나는가?
		
		
		String s4 = "abc abc abcdef";
		int idx = s4.indexOf("a");
		System.out.println("s4.indexOf(\"a\") : "+idx); //a는 몇번째부터 나오는가
		System.out.println("s4.indexOf(\" abc\") : "+s4.indexOf(" abc"));//" abc몇번째부터 나오는가 (띄어쓰기 포함)

		System.out.println("s4.lastIndexOf(\"a\") : "+s4.lastIndexOf("a"));//제일 마지막a는 몇번째인가?
		System.out.println("s4.lastIndexOf(\" abc\") : "+s4.lastIndexOf(" abc"));//제일 마지막 " abc"는 몇번째인가?
		System.out.println("s4.indexOf(\"a\", 2) : "+s4.indexOf("a", 2));//두번째 글자부터 시작하여 나오는 a는 몇번째인가?

		char c = s4.charAt(5);
		System.out.println("s4.charAt(5) : "+c);//s4의 5번째 글자는 무엇인가?
		System.out.println("s4.length()-1 : "+(s4.length()-1));//s4의 마지막 글자는 무엇인가?
		String s5 = "안녕하세요. Hello. 반갑습니다.";
		String ss = s5.substring(14);//14번째부터 출력.
		System.out.println("s5.substring(14) : "+ss);
		System.out.println("s5.substring(7, 12) : "+s5.substring(7, 12)); // 7번째부터 12-1번째까지 출력

		ss = s3.toLowerCase();
		System.out.println(s3+","+ss);//s3을 소문자로 변경하여 출력
		ss = s1.toUpperCase();
		System.out.println(s1+","+ss);//s1을 대문자로 변경하여 출력
		
		String s6 = "ababaaabb";
		ss = s6.replace('a', 'k');
		System.out.println(s6+","+ss); //s6에서의 a를 모두 k로 변경
		
		ss = s5.replaceAll("Hello", "헬로");
		System.out.println(s5+","+ss);//s5에서의 Hello를 모두 헬로로 변경
		
		String s7 = "사과.배.귤,포도,딸기,메론,바나나";
		String [] fruit = s7.split("\\."); // . 을 기준으로 한칸 밑으로(나눔)
		System.out.println("------split() : 과일들----");
		for(String str : fruit){
			System.out.println(str);
		}
	}
}
//StringTest.java
