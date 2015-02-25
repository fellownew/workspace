package thread.basic.runnable;

public class PrintAtoZ implements Runnable{
	@Override
	public void run(){
		for(int i=65;i<90;i++)
			System.out.print((char)(i)+" ");
	}
}
