package thread.basic;

public class PrintAtoZ  extends Thread{
	@Override
	public void run(){
		for(int i=65;i<90;i++)
			System.out.print((char)(i)+" ");
	}
}
