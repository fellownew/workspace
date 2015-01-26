package day13.composition;

public class TestComposition {
	public static void main(String[] args) {
		
	Computer c1 = new Computer();
	c1.setMaker("LG");
	c1.setPrice(230000);
	System.out.println(c1.toString());
	
	Computer c2 = new Computer("Samsung",850000,new Cpu("인텔","i3","DualCore"));
	System.out.println(c2.toString());
	
	Computer c3 = new Computer(new Cpu("인텔","i7","QuadCore"));
	System.out.println(c3.toString());
	}
}