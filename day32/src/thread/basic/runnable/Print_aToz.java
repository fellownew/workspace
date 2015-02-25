package thread.basic.runnable;

public class Print_aToz  implements Runnable{
	@Override
	public void run(){
		for(int i=97;i<123;i++)
			System.out.print((char)(i)+" ");
	}
}
