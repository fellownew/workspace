package objecttest;

public class TestEqual {
	public static void main(String[] args) {
		Compare1 c1 = new Compare1("ȫ�浿","����",20);
		Compare1 c2 = new Compare1("ȫ�浿","����",20);
		Compare2 c3 = new Compare2("ȫ�浿","����",20);
		Compare2 c4 = new Compare2("�Ӳ���","���",21);
		Compare1 c5 = new Compare1("�Ӳ���","���",20);
		System.out.println(c1.equals(c2));
		System.out.println(c2.equals(c3));
		System.out.println(c3.equals(c4));
		System.out.println(c4.equals(c5));
		System.out.println(c5.equals(c1));
		System.out.println(c1.getClass());
		System.out.println(c3.getClass());
	}
}
