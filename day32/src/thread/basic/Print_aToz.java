package thread.basic;

public class Print_aToz  extends Thread{
	@Override
	public void run(){
		for(int i=97;i<123;i++)
			System.out.print((char)(i)+" ");
	}
}
