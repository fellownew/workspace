package thread.basic;

public class Print1To26 extends Thread{
	/*
	 * (non-Javadoc)
	 * @see java.lang.Thread#run()
	 * Thread�� ������ �ڵ带 ������ �޼ҵ� (main thread�� main�޼ҵ�� ���� ����)
	 * Thread : public void run(){} - �޼ҵ� overriding
	 */
	
	
	@Override
	public void run(){
		for(int i=0;i<27;i++)
			System.out.print(i+" ");
	}
}
