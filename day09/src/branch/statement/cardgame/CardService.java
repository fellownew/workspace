package branch.statement.cardgame;

public class CardService {

	public String getCardType(int cardT) {
		String str;
		if (cardT == 0) {
			str = "��";
		} else if (cardT == 1) {
			str = "��";
		} else if (cardT == 2) {
			str = "��";
		} else if (cardT == 3) {
			str = "��";
		} else {
			str = "����";
		}
		return str;
	}

	public String getCardNumber(int cardN) {
		String str=null;
/*		switch (cardN) {
		case 1:
			str = "ACE";
			break;
		case 11:
			str = "JACK";
			break;
		case 12:
			str = "QUEEN";
			break;
		case 13:
			str = "KING";
			break;
		default:
			str = cardN + "";
		}
*/

		if (cardN == 1) {
			str = "ACE";
		} else if (cardN == 11) {
			str = "JACK";
		} else if (cardN == 12) {
			str = "QUEEN";
		} else if (cardN == 13) {
			str = "KING";
		} else if (2<=cardN && cardN<=10){
			str = cardN + "";
		}
		return str;
	}
}
