package collection;

import java.util.TreeSet;

public class LottoSet {
	public static void main(String[] args) {
		createLottoNumber(10);
	}

	public static void createLottoNumber(int num) {
		for (int j = 0; j < num; j++) {
			// HashSet set = new HashSet();
			TreeSet set1 = new TreeSet(); // 정렬기능 추가.
			for (int i = 0; i < 6; i++) {
				boolean b = set1.add((int) (Math.random() * 45) + 1);
				if (!b)
					i--;
			}
			for (Object o : set1) {
				System.out.print(o + "   ");
			}
			System.out.println();
		}
	}
}