package io.charstream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy_Character {
	private String srcPath = "C:\\JAVA\\news.txt";

	public static void main(String[] args) throws IOException {
		FileCopy_Character fc = new FileCopy_Character();
		fc.copyNews();
		fc.copyNews("C:\\JAVA\\news2.txt");

	}
	
	//srcPath에 있는 Text를 읽어서 커맨트 창에 출력하는 메소드.
	//input : FileReader, read(char[])을 이용한 input
	//output : System.out.print() 
	public void copyNews() throws IOException {
		FileReader fr = null;
		char[] c = new char[100];
		try{
			fr = new FileReader(srcPath);
			int i = fr.read(c);
			while(i!=-1){
				System.out.print(c); // c 버퍼에 남아있는것이 있다보니 print로 모니터 출력했을때 쓰레기값이 들어가는 문제점이 생김.
				i = fr.read(c);
			}
		}finally{
			if(fr!=null)fr.close();
		}
	}
//srcPath에 있는 Text를 읽어서 다른 text파일을 복사하는 메소드.
//Input : FileReader,
//Output : FileWriter.
	public void copyNews(String targetFile) throws IOException {
		FileReader fr = null;
		FileWriter fw = null;
		char[] c = new char[100];
		try{
			fr = new FileReader(srcPath);
			fw = new FileWriter(targetFile);
			int i = fr.read(c);
			while(i != -1){
				fw.write(c,0,i);
				i = fr.read(c);
			}
		}finally{
			if(fr!=null)fr.close();
			if(fw!=null)fw.close();
		}
	}
}
