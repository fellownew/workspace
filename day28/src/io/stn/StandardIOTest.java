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
		//표준입력 : 키보드로부터 입력 (System.in 사용)
		//System.in : InputStream
		System.out.println("글 입력 후 엔터를 치세요 - 1byte");
		int i = System.in.read(); // 1byte read 이기때문에 문자열을 제대로 읽지 못함.
		//System.out(정상출력), System.err(에러출력) : PrintStream
		System.out.println((char)i);
	}
	
	public void standardInput2() throws IOException{
		InputStream is = System.in;
		InputStreamReader isr= new InputStreamReader(is);
		System.out.println("글 입력 후 엔터를 치세요 - 2byte");
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
			System.out.println("글 입력 후 엔터를 치세요 - Line");
			String s = br.readLine();
			//IOBlocking : 연결된 OUtputStream에서 출력을 하지 않은 상태에서 InputStream이 읽을 경우(read) 읽을 것이 생길때 까지 대기하는 상황.
			while(s!=null){
				System.out.println(s);
				s = br.readLine();
			}
			System.out.println("종료");
		}finally{
			if(br!=null){
				br.close();
			}
		}
	}
}