package exception.basic;
//JVM��main()��a()��b()��c()
//JVM��main()��a()��b()��return

public class ExceptionTest4 {
	public static void main(String[] args) {
		System.out.println("main ����");
		new ExceptionTest4().a();
		System.out.println("main ����");
	}
	public void a(){
		System.out.println("\ta() ����");
		b();
		System.out.println("\ta() ����");
	}
	public void b(){
		System.out.println("\t\tb() ����");
		try{
		c();
		}catch(NullPointerException e){
			System.err.println("���� ó��");
		}
		System.out.println("\t\tb() ����");
	}
	public void c(){
		System.out.println("\t\t\tc() ����");
		if(Math.random()<0.5){
		throw new NullPointerException();//throw�� ���ܸ� �߻���Ŵ.
		}
		System.out.println("\t\t\tc() ����");
		
	}
}
