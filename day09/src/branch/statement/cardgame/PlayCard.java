package branch.statement.cardgame;

public class PlayCard {
	public static void main(String[] args) {
		int cardT = (int)(Math.random() * 3.9);
		int cardN = (int)(Math.random() * 12.9)+1;

		CardService cs = new CardService();
		String cardType = cs.getCardType(cardT);
		String cardNum = cs.getCardNumber(cardN);
		System.out.println("����� ���� ī��� " + cardType + " " + cardNum + "�Դϴ�.");
	}

}
