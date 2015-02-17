package io.stn.memo;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ConsoleMemo {
	public static void main(String[] args) throws IOException {
		ConsoleMemo memo = new ConsoleMemo();
		memo.Note2();
	}

	public void Note() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = null;
		String fileName;
		try {
			System.out.println("저장할 파일명을 지정해주세요");
			System.out.print("파일명 : ");
			fileName = br.readLine(); // 파일명을 받음
			pw = new PrintWriter("C:\\JAVA\\temp\\" + fileName + ".txt"); // print할파일연결
			System.out.println("내용을 입력해주세요 / 종료 : ctrl+z");
			String str = br.readLine(); // 내용을 받음
			while (str != null) {
				pw.println(str); // 받은 내용을 pw에 저장.
				str = br.readLine(); // 또 받음.
			} // null이 될때까지 계속 받음.
		} finally {
			if (pw != null)
				pw.close();
			if (br != null)
				br.close();
		}
	}

	public void Note2() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = null;
		String fileName;
		try {
			System.out.println("저장할 파일명을 지정해주세요");
			System.out.print("파일명 : ");
			fileName = br.readLine(); // 파일명을 받음
			File file = new File("C:\\JAVA\\temp\\" + fileName + ".txt");
			while (file.exists()) {
				System.out.println("중복되는 파일명이 있습니다. 다시 파일명을 지정해주세요");
				System.out.print("파일명 : ");
				fileName = br.readLine(); // 파일명을 받음
				file = new File("C:\\JAVA\\temp\\" + fileName + ".txt");
			}

			pw = new PrintWriter("C:\\JAVA\\temp\\" + fileName + ".txt"); // print할 파일 연결
			System.out.println("내용을 입력해주세요 / 종료 : ctrl+z");
			String str = br.readLine(); // 내용을 받음
			while (str != null) {
				pw.println(str); // 받은 내용을 pw에 저장.
				str = br.readLine(); // 또 받음.
			} // null이 될때까지 계속 받음.
		} finally {
			if (pw != null)
				pw.close();
			if (br != null)
				br.close();
		}
	}
}