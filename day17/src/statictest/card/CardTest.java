package statictest.card;

public class CardTest {
	public static void main(String[] args) {
		//static 변수/메소드는 클래스명.변수/메소드명  으로 접근 함.
		System.out.println("카드 높이 : "+Card.getHeight());
		System.out.println("카드 너비 : "+Card.getWidth());
		new Card();new Card();new Card();new Card();new Card();new Card();new Card();new Card();
		new Card(3,"다야");
		System.out.println("지금까지 생성된 카드의 수는 "+Card.getCount()+"장입니다.");
	}
}
