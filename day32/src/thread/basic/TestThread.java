package thread.basic;

public class TestThread {
	public static void main(String[] args) {
		Print1To26 pn = new Print1To26();
		PrintAtoZ pa = new PrintAtoZ();
		Print_aToz p_a = new Print_aToz();
		
		System.out.println("TestThread.main ����");
		// run()���� �θ��°� �ƴ�.
		pn.start();
		pa.start();
		p_a.start(); 
		System.out.println("\nTestThread.main ����");
	}
}
