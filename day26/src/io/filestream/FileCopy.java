package io.filestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
public static void main(String[] args) {
	FileCopy fc = new FileCopy();
	String srcFile = "C:\\JAVA\\Lighthouse.jpg";
	String targetFile = "C:\\JAVA\\Lighthouse2.jpg";
	try {
		fc.copy2(srcFile, targetFile);
	}catch(IOException e){ //FileNotFoundException은 IOException의 하위
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public void copy1(String srcFile, String targetFile) throws IOException, FileNotFoundException {
		// srcFile경로의 파일을 targetFile 경로로 카피하는 메소드
		// file과 연결해서 binary data를 입력받는 스트림 클래스
		// FileInputStream : 객체 생성시 연결할 파일 정보를 주어야 한다.
		FileInputStream fis=null;	 //try와 finally 양 block 내에서 사용할 변수이므로 try 밖에서 선언함.
		//File과 연결해서 binary data를 출력하는 stream클래스가 필요함.
		
		FileOutputStream fos = null;//객체 생성시 연결할 파일 정보를 줌. - 파일이 없다면 새로 만듦.
											//이미 존재하는 파일일때 이어쓰기 여부 (기본 false : 새로쓰기)
		try {
			fis = new FileInputStream(srcFile);
			fos = new FileOutputStream(targetFile);//덮어쓰기 형식.
			//읽기 및 쓰기
			int i = fis.read();	
			while(i!=-1){
				fos.write(i);
				i = fis.read();	
			}//srcFile 읽기/쓰기 종료
		}finally{
			if(fis!=null){
				fis.close();
			}
			if(fos!=null){
				fos.close();
			}
		}
	}
	
	public void copy2(String srcFile, String targetFile) throws IOException, FileNotFoundException {
		//byte[]를 이용한 입출력
		FileInputStream fis=null;	 
		FileOutputStream fos = null;
		byte[] b = new byte[1000000];
		try {
			fis = new FileInputStream(srcFile);
			fos = new FileOutputStream(targetFile);
			//읽기 및 쓰기
			int i= fis.read(b);//b에 읽은 byte를 넣어줌. 읽은 byte수를 return. EOF를 읽은 경우 -1 리턴
			while(i!=-1){
				fos.write(b,0,i);//b에 있는 byte들을 한번에 출력하되 0번index에서 i만큼 한번에 출력(쓰기)
				i = fis.read(b);	
			}//읽기 및 쓰기 종료
		}finally{
			//연결 닫기
			if(fis!=null){
				fis.close();
			}
			if(fos!=null){
				fos.close();
			}
		}
	}
}
