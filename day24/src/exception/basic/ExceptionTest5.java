package exception.basic;

import java.io.IOException;

public class ExceptionTest5 {
	public static void main(String[] args){
		System.out.println("main 시작");
		new ExceptionTest5().a();
		System.out.println("main 종료");
	}
	public void a(){
		System.out.println("\ta() 시작");
		b();
		System.out.println("\ta() 종료");
	}
	public void b(){
		System.out.println("\t\tb() 시작");
		try{
		c();
		}catch(Exception e){
			System.out.println("-예외 처리-");
		}
		System.out.println("\t\tb() 종료");
	}
	public void c() throws IOException{
		System.out.println("\t\t\tc() 시작");
		if(Math.random()<0.15){
		throw new IOException();//throw로 예외를 발생시킴.
		}
		System.out.println("\t\t\tc() 종료");
	}
}
