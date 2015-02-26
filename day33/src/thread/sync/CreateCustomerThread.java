package thread.sync;

public class CreateCustomerThread extends Thread {
	//10명의 고객을 생성 , 고객ID(번호) - cust-순서번호.
	//(cust-1,cust-2)...
	private MakeSequenceNumber makeNum;
	
	public CreateCustomerThread(MakeSequenceNumber makeNum) {
		this.makeNum = makeNum;
	}

	@Override
	public void run() {
		for(int i = 0;i<10;i++){
			System.out.println("생성된 고객 번호 : cust-"+makeNum.getNextNumber());
		}
	}
}
