package thread.basic.runnable;

public class Print1To26 implements Runnable{//Thread�� ������ �� �ִ�... �̶�� ����.
/*
 * (non-Javadoc)
 * @see java.lang.Runnable#run()
 * implements Runnable���� public void run() �������̵�
 * 
 */
	
	
	@Override
	public void run(){
		for(int i=0;i<27;i++)
			System.out.print(i+" ");
	}
}
