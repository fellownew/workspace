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
				System.out.println("1. 등록 2. 전체조회 3. 종료");
				String menu = br.readLine();
				String name;
				if (menu.equals("1")) {
					System.out.print("이름 : ");
					name = br.readLine();
					System.out.print("나이 : ");
					int age = 0;
					try {
						age = Integer.parseInt(br.readLine());
					} catch (NumberFormatException e) {
						System.err.println("나이는 숫자를 넣으세요");
						continue;
					}
						System.out.print("전화번호 : ");
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
			System.out.println("종료");
		} finally {
			if (br != null)
				br.close();
		}
	}
}