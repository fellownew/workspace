package exception.basic;
//JVM→main()→a()→b()→c()
//JVM←main()←a()←b()←return

public class ExceptionTest4 {
	public static void main(String[] args) {
		System.out.println("main 시작");
		new ExceptionTest4().a();
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
		}catch(NullPointerException e){
			System.err.println("예외 처리");
		}
		System.out.println("\t\tb() 종료");
	}
	public void c(){
		System.out.println("\t\t\tc() 시작");
		if(Math.random()<0.5){
		throw new NullPointerException();//throw로 예외를 발생시킴.
		}
		System.out.println("\t\t\tc() 종료");
		
	}
}
