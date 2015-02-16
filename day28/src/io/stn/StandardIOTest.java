package io.stn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StandardIOTest{
	public static void main(String[] args) throws IOException{
		StandardIOTest st = new StandardIOTest();
		st.standardInput3();
	}

	public void standardInput1() throws IOException{
		//ǥ���Է� : Ű����κ��� �Է� (System.in ���)
		//System.in : InputStream
		System.out.println("�� �Է� �� ���͸� ġ���� - 1byte");
		int i = System.in.read(); // 1byte read �̱⶧���� ���ڿ��� ����� ���� ����.
		//System.out(�������), System.err(�������) : PrintStream
		System.out.println((char)i);
	}
	
	public void standardInput2() throws IOException{
		InputStream is = System.in;
		InputStreamReader isr= new InputStreamReader(is);
		System.out.println("�� �Է� �� ���͸� ġ���� - 2byte");
		int i = isr.read();
		while(i!=-1){ // ctrl+z : EOF
			System.out.print((char)i);
			i = isr.read();
		}
	}
	
	public void standardInput3() throws IOException{
		BufferedReader br = null;
		try{
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("�� �Է� �� ���͸� ġ���� - Line");
			String s = br.readLine();
			//IOBlocking : ����� OUtputStream���� ����� ���� ���� ���¿��� InputStream�� ���� ���(read) ���� ���� ���涧 ���� ����ϴ� ��Ȳ.
			while(s!=null){
				System.out.println(s);
				s = br.readLine();
			}
			System.out.println("����");
		}finally{
			if(br!=null){
				br.close();
			}
		}
	}
}