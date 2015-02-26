package thread.join;

public class JoinTest {
	public static void main(String[] args) {
		PlusThread p1 =new PlusThread(1,10);
		PlusThread p2 =new PlusThread(1,100);
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		
		t1.start();
		t2.start();
		//t1 �����尡 ���� �ɋ� ���� ���� �������� Thread(main Thread)�� blocked���°� �Ǿ� ���� �����.
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("main.p1.sum : "+p1.getSum());
		System.out.println("main.p2.sum : "+p2.getSum());
	}
}
