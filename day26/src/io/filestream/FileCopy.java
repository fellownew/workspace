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
	}catch(IOException e){ //FileNotFoundException�� IOException�� ����
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public void copy1(String srcFile, String targetFile) throws IOException, FileNotFoundException {
		// srcFile����� ������ targetFile ��η� ī���ϴ� �޼ҵ�
		// file�� �����ؼ� binary data�� �Է¹޴� ��Ʈ�� Ŭ����
		// FileInputStream : ��ü ������ ������ ���� ������ �־�� �Ѵ�.
		FileInputStream fis=null;	 //try�� finally �� block ������ ����� �����̹Ƿ� try �ۿ��� ������.
		//File�� �����ؼ� binary data�� ����ϴ� streamŬ������ �ʿ���.
		
		FileOutputStream fos = null;//��ü ������ ������ ���� ������ ��. - ������ ���ٸ� ���� ����.
											//�̹� �����ϴ� �����϶� �̾�� ���� (�⺻ false : ���ξ���)
		try {
			fis = new FileInputStream(srcFile);
			fos = new FileOutputStream(targetFile);//����� ����.
			//�б� �� ����
			int i = fis.read();	
			while(i!=-1){
				fos.write(i);
				i = fis.read();	
			}//srcFile �б�/���� ����
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
		//byte[]�� �̿��� �����
		FileInputStream fis=null;	 
		FileOutputStream fos = null;
		byte[] b = new byte[1000000];
		try {
			fis = new FileInputStream(srcFile);
			fos = new FileOutputStream(targetFile);
			//�б� �� ����
			int i= fis.read(b);//b�� ���� byte�� �־���. ���� byte���� return. EOF�� ���� ��� -1 ����
			while(i!=-1){
				fos.write(b,0,i);//b�� �ִ� byte���� �ѹ��� ����ϵ� 0��index���� i��ŭ �ѹ��� ���(����)
				i = fis.read(b);	
			}//�б� �� ���� ����
		}finally{
			//���� �ݱ�
			if(fis!=null){
				fis.close();
			}
			if(fos!=null){
				fos.close();
			}
		}
	}
}
