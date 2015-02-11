package collection.etc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorTest {
	public static void main(String[] args) {
		HashSet set = new HashSet();
		set.add("abc");
		set.add("def");
		set.add("ghi");
		//itertator ����
		Iterator ite = set.iterator();
		while(ite.hasNext()){ //���� ���� �����ϴ��� Ȯ�� �Ͽ� true/false
			System.out.println(ite.next()); //���� �����ҷ���.
			/*
			 * Object o = ite.next();
			 * system.out.println(o);
			 */
		}
		System.out.println("----------------------");
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(10);
		al.add(20);
		al.add(30);
		al.add(40);
		Iterator<Integer> ite2 = al.iterator();
		while(ite2.hasNext()){
			Integer i = ite2.next();
			System.out.println(i);
		}
	}
}
