package thread.sync;

public class CreateCustomerThread extends Thread {
	//10���� ���� ���� , ��ID(��ȣ) - cust-������ȣ.
	//(cust-1,cust-2)...
	private MakeSequenceNumber makeNum;
	
	public CreateCustomerThread(MakeSequenceNumber makeNum) {
		this.makeNum = makeNum;
	}

	@Override
	public void run() {
		for(int i = 0;i<10;i++){
			System.out.println("������ �� ��ȣ : cust-"+makeNum.getNextNumber());
		}
	}
}
