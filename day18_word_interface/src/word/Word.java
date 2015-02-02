package word;

import word.format.Format;

public class Word{
	public void print(String message,Format format){
		System.out.println(format.getFormat(message));
	}
}
