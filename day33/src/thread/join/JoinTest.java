package thread.join;

public class JoinTest {
	public static void main(String[] args) {
		PlusThread p1 =new PlusThread(1,10);
		PlusThread p2 =new PlusThread(1,100);
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		
		t1.start();
		t2.start();
		//t1 쓰레드가 종료 될떄 까지 현재 실행중인 Thread(main Thread)는 blocked상태가 되어 일을 멈춘다.
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
