package thread.basic;

public class TestThread {
	public static void main(String[] args) {
		Print1To26 pn = new Print1To26();
		PrintAtoZ pa = new PrintAtoZ();
		Print_aToz p_a = new Print_aToz();
		
		System.out.println("TestThread.main 시작");
		// run()으로 부르는게 아님.
		pn.start();
		pa.start();
		p_a.start(); 
		System.out.println("\nTestThread.main 종료");
	}
}
