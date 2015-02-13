package io.charstream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class fileCopy_Filter {
	public static void main(String[] args) throws IOException {
		fileCopy_Filter ff = new fileCopy_Filter();
		ff.copyNews("C:\\JAVA\\news.txt", "C:\\JAVA\\news33.txt");
	}
	
	public void copyNews(String srcPath, String targetPath) throws IOException{
		BufferedReader br = null;
		PrintWriter pw =null;
		try{
			br = new BufferedReader(new FileReader(srcPath));
			pw = new PrintWriter(targetPath);
			
			String s = br.readLine();
			while(s!=null){
				pw.println(s);
				s = br.readLine();
			}		
		}finally{
			if(br!=null)br.close();
			if(pw!=null)pw.close();
		}
		System.out.println("복사가 완료되었습니다.");	
	}
}
