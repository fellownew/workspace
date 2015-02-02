package object;

import object.vo.Member;

public class TestMember {
	public static void main(String[] args) {
		Member m = new Member("abc","±èÃ¶¼ö",25);
		System.out.println(m);
	}
}
