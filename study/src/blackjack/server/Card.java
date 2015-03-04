package blackjack.server;

public class Card {
	public static final int SPADE=1;
	public static final int DIAMOND=2;
	public static final int CLOVER=3;
	public static final int HEART=4;
	public static final int ACE =1;
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;

	private int pattern, number;
	public Card(int pattern, int number) {
		this.pattern = pattern;
		this.number = number;
	}	
}
