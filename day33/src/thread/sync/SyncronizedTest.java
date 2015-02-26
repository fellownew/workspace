package thread.sync;

public class SyncronizedTest {
	public static void main(String[] args) {
		MakeSequenceNumber makeNum = new MakeSequenceNumber();
		CreateCustomerThread t1 = new CreateCustomerThread(makeNum);
		CreateVIPCustomerThread t2 = new CreateVIPCustomerThread(makeNum);
		t1.start();
		t2.start();
	}
}
