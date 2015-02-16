package io.stn.member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MTest {
	public static void main(String[] paramArrayOfString) throws IOException {
		ArrayList<Member> memberlist = new ArrayList<Member>();
		BufferedReader br = null;
		try {
			int i = 1;
			while (i != 0) {
				br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("1. ��� 2. ��ü��ȸ 3. ����");
				String menu = br.readLine();
				String name;
				if (menu.equals("1")) {
					System.out.print("�̸� : ");
					name = br.readLine();
					System.out.print("���� : ");
					int age = 0;
					try {
						age = Integer.parseInt(br.readLine());
					} catch (NumberFormatException e) {
						System.err.println("���̴� ���ڸ� ��������");
						continue;
					}
						System.out.print("��ȭ��ȣ : ");
						String telNum = br.readLine();
						memberlist.add(new Member(name, age, telNum));

				} else if (menu.equals("2")) {
					for (Member member : memberlist) {
						System.out.println(member);
					}
				} else if (menu.equals("3")) {
					i = 0;
				}
			}
			System.out.println("����");
		} finally {
			if (br != null)
				br.close();
		}
	}
}