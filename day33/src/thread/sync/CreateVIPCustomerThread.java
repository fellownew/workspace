package thread.sync;

public class CreateVIPCustomerThread extends Thread {
	private MakeSequenceNumber makeNum;
	
	public CreateVIPCustomerThread(MakeSequenceNumber makeNum) {
		this.makeNum = makeNum;
	}
	
	public void run() {
		for(int i = 0;i<10;i++){
			System.out.println("������ VIP�� ��ȣ : VIPcust-"+makeNum.getNextNumber());
		}
	}
}