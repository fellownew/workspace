package exception.basic;

import java.io.IOException;

public class ExceptionTest5 {
	public static void main(String[] args){
		System.out.println("main ����");
		new ExceptionTest5().a();
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
		}catch(Exception e){
			System.out.println("-���� ó��-");
		}
		System.out.println("\t\tb() ����");
	}
	public void c() throws IOException{
		System.out.println("\t\t\tc() ����");
		if(Math.random()<0.15){
		throw new IOException();//throw�� ���ܸ� �߻���Ŵ.
		}
		System.out.println("\t\t\tc() ����");
	}
}
