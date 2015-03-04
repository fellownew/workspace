package blackjack.server;

import java.util.ArrayList;
import java.util.Random;

public class CardManager {
	private static ArrayList<Card> cardList = null;
	private static Random random = new Random();
	public CardManager() {
		for(int i = 1;i<=4;i++){
			for(int j = 1;j<=13;j++){
				cardList.add(new Card(i, j));
			}
		}
	}
	
	public static Card getCard(){
		int index = random.nextInt(cardList.size());
		Card temp = cardList.get(index);
		cardList.remove(index);
		return temp;
	}
	
	public static void clearCard(){
		cardList.clear();
	}
	
}//cardmanager end