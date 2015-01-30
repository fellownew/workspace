package statictest.card;

public class Card {
	private int number; // ī�� ��ȣ
	private String kind; // ī�� ����
	
	//static : Ŭ������ �ɹ��� ��. class�̸�.������, class�̸�.�޼ҵ��  ���� ȣ��.(��ü ���� �ʿ����.)
	//static ������ �ʱ�ȭ�� �ʿ��� ��� �����ϸ鼭 ���� ���� �����Ѵ�.
	private static double width=6.25;
	private static double height=8.8;
	private static int count=0;
	
	public Card(){
		count++;
	}
	public Card(int number,String kind){
		super();
		this.number = number;
		this.kind =kind;
		count++;
	}
	@Override
	public String toString() {
		return "ī�� ���� : "+kind+"ī�� ��ȣ : "+number;
	}
	public static double getWidth() {
		return width;
	}
	public static void setWidth(double width) {
		Card.width = width; //static ���� width = �������� width
	}
	public static double getHeight() {
		return height;
	}
	public static void setHeight(double height) {
		Card.height = height;
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Card.count = count;
	}
	
	 
}
