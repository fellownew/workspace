package thread.sync;

//1�� �����ϴ� ���ӵ� ������ �����ϴ� Ŭ����
public class MakeSequenceNumber {
	private int num;
	
	public int getNextNumber(){
		synchronized (this) {//this ��ü�� lock flag(����)�� ���� Thread�� ���� �� �� �ִ� ��.
			num+=1;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return num;
		}//Thread�� ����ȭ ���� ���������� lockflag(����)�� (this)�� �ݳ� ��.
	}
}