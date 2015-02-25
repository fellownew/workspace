package thread.basic;

public class Print1To26 extends Thread{
	/*
	 * (non-Javadoc)
	 * @see java.lang.Thread#run()
	 * Thread가 실행할 코드를 구현할 메소드 (main thread의 main메소드와 같은 역할)
	 * Thread : public void run(){} - 메소드 overriding
	 */
	
	
	@Override
	public void run(){
		for(int i=0;i<27;i++)
			System.out.print(i+" ");
	}
}
