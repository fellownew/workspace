package thread.basic.runnable;

public class TestThread {
	public static void main(String[] args) {
		Print1To26 pn = new Print1To26();
		PrintAtoZ pa = new PrintAtoZ();
		Print_aToz p_a = new Print_aToz();
		Thread p1 = new Thread(pn);
		Thread p2 = new Thread(pa);
		Thread p3 = new Thread(p_a);
		
		System.out.println("TestThread.main 시작");
		// run()으로 부르는게 아님.
		p1.start();
		p2.start();
		p3.start(); 
		System.out.println("\nTestThread.main 종료");
	}
}
