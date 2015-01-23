package day12.array;

public class ArrayTest3 {
	//args - command line argument : 실행시 사용자로부터 전달 받을 문자열들 저장할 변수로 JVM이 전달함.
	public static void main(String[] args) {
		System.out.println("args length : "+args.length );
		for(String s:args){
			System.out.println(s);
			
			ArrayTest3 at = new ArrayTest3();
			at.testVarArgs("asasdf");
		}
	}
	//가변인수(VarArgs) : DataType... 변수명 - 호출하는 곳에서 받은 전달인자의 개수가 동적일 경우 사용. 내부적으로는 배열 처리
	//			가변인수 선언 뒤에는 매개변수 선언불가.
	public void testVarArgs(String... strs){
		System.out.println("전달된 가변 인수 값");
		for(String s:strs){
			System.out.println(s);
		}
		
	}
	
}
