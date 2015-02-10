package exception.basic;

public class FinallyTest {
	public static void main(String[] args) {
//		finallyTest1();
		finallyTest2(3);
	}
	
	public static void finallyTest1(){
		int[] arr = {1,2,3,4,5};
		for(int i = 0;i<=arr.length;i++){
			try{
			System.out.println("배열의"+i+"의 값 : "+arr[i]);
			if(i==2){int k = 10/0;}
			}catch(ArrayIndexOutOfBoundsException e){
				System.err.println("예외 발생");
			}finally{
				System.out.println("\tfinally 블럭 - 무조건 실행");
			}
		}
		System.out.println("finallyTest1() 종료");
	}
	public static void finallyTest2(int var){
		System.out.println("finallyTest2() 시작");
		try{
			if(var==1){
				System.out.println("정상적으로 실행되는 구문");
			}else if(var==2){
				System.out.println(10/0);//예외 발생 구문
			}else if(var==3){
				System.exit(0); // 프로그램을 종료시키는 메소드. -> 이런경우 finally가 실행이 안됨.
//				return;//리턴
			}
		}finally{
			System.out.println("finally 블럭");
		}
		System.out.println("finallyTest2() 종료");
	}
}
