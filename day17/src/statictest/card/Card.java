package statictest.card;

public class Card {
	private int number; // 카드 번호
	private String kind; // 카드 종류
	
	//static : 클래스의 맴버가 됨. class이름.변수명, class이름.메소드명  으로 호출.(객체 생성 필요없음.)
	//static 변수는 초기화가 필요할 경우 선언하면서 값을 직접 대입한다.
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
		return "카드 종류 : "+kind+"카드 번호 : "+number;
	}
	public static double getWidth() {
		return width;
	}
	public static void setWidth(double width) {
		Card.width = width; //static 변수 width = 지역변수 width
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
