package word;

import word.format.AstaFormat;
import word.format.EquFormat;
import word.format.Format;
import word.format.PlusFormat;
import word.format.SharpFormat;

public class WordUser {
	public static void main(String[] args) {
		Word w = new Word();
		Format f1 = new AstaFormat();
		Format f2 = new EquFormat();
		Format f3 = new PlusFormat();
		Format f4 = new SharpFormat();
		
		w.print("�׽�Ʈ1", f1);
		w.print("�׽�Ʈ2", f2);
		w.print("�׽�Ʈ3", f3);
		w.print("�׽�Ʈ4", f4);
	}
}
