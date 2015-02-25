package thread.basic.runnable;

public class Print1To26 implements Runnable{//Thread로 실행할 수 있는... 이라는 뜻임.
/*
 * (non-Javadoc)
 * @see java.lang.Runnable#run()
 * implements Runnable이후 public void run() 오버라이드
 * 
 */
	
	
	@Override
	public void run(){
		for(int i=0;i<27;i++)
			System.out.print(i+" ");
	}
}
