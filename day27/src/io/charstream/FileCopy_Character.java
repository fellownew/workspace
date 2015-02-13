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
	
	//srcPath�� �ִ� Text�� �о Ŀ��Ʈ â�� ����ϴ� �޼ҵ�.
	//input : FileReader, read(char[])�� �̿��� input
	//output : System.out.print() 
	public void copyNews() throws IOException {
		FileReader fr = null;
		char[] c = new char[100];
		try{
			fr = new FileReader(srcPath);
			int i = fr.read(c);
			while(i!=-1){
				System.out.print(c); // c ���ۿ� �����ִ°��� �ִٺ��� print�� ����� ��������� �����Ⱚ�� ���� �������� ����.
				i = fr.read(c);
			}
		}finally{
			if(fr!=null)fr.close();
		}
	}
//srcPath�� �ִ� Text�� �о �ٸ� text������ �����ϴ� �޼ҵ�.
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
