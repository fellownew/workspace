package io.stn.memo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ConsoleMemo {
	public static void main(String[] args) throws IOException {
		ConsoleMemo memo = new ConsoleMemo();
		memo.Note();
	}

	public void Note() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = null;
		String fileName;
		try {
			System.out.println("������ ���ϸ��� �������ּ���");
			System.out.print("���ϸ� : ");
			fileName = br.readLine(); //���ϸ��� ����
			pw = new PrintWriter("C:\\JAVA\\temp\\" + fileName + ".txt"); //print�� ���� ����
			System.out.println("������ �Է����ּ��� / ���� : ctrl+z");
			String str = br.readLine(); // ������ ����
			while (str != null) {
				pw.println(str);    // ���� ������ pw�� ����.
				str = br.readLine(); // �� ����.
			} //null�� �ɶ����� ��� ����.
		} finally {
			if (pw != null)pw.close();
			if (br != null) br.close();
		}
	}
}