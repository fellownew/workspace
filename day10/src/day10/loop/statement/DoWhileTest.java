package day10.loop.statement;

import java.io.*;

public class DoWhileTest {
	public static void main(String[] args) throws IOException {
		int i = 0;
		do {
			System.out.print("���� �Է��� ���� : ");
			i = System.in.read();
			char c = (char) i;
			System.out.println("�Է� ���� ���� Ȯ�� : " + c);
		} while ((char)i != '1');  //�Է¹��� 1�ƴϸ� ���� ����
		System.out.println("����");
	}
}