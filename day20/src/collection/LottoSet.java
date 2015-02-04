package collection;

import java.util.HashSet;

public class LottoSet {
	public static void main(String[] args) {
		createLottoNumber();
	}

	public static void createLottoNumber() {
		HashSet set1 = new HashSet();
		for (int i = 0; i < 6; i++) {
			set1.add((int) (Math.random() * 46));
		}
		for (Object o : set1) {
			System.out.println(o);
		}
	}
}
