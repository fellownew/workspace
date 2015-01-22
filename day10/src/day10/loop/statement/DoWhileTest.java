package day10.loop.statement;

import java.io.*;

public class DoWhileTest {
	public static void main(String[] args) throws IOException {
		int i = 0;
		do {
			System.out.print("문자 입력후 엔터 : ");
			i = System.in.read();
			char c = (char) i;
			System.out.println("입력 받은 글자 확인 : " + c);
		} while ((char)i != '1');  //입력문자 1아니면 무한 루프
		System.out.println("종료");
	}
}