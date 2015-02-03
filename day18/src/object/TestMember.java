package object;

import object.vo.Member;

public class TestMember {
	public static void main(String[] args) {
		Member m = new Member("Id-1","±èÃ¶¼ö",25);
		System.out.println(m);
		Member m1 = new Member("Id-1","±èÃ¶¼ö",25);
		Member m2 = new Member("Id-2","±è¿µÈñ",25);
		Member m3 = new Member("Id-2","±è¿µÈñ",25);
		Member m4 = new Member("Id-3","È«±æµ¿",25);
		System.out.println(m.equals(m1));
		System.out.println(m1.equals(m2));
		System.out.println(m2.equals(m3));
		System.out.println(m3.equals(m4));
		System.out.println(m4.equals(m1));
		System.out.println(m.hashCode());
		System.out.println(m.getId().hashCode());
	}
}
