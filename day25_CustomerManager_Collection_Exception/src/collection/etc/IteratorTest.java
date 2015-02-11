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
		//itertator 생성
		Iterator ite = set.iterator();
		while(ite.hasNext()){ //다음 값이 존재하는지 확인 하여 true/false
			System.out.println(ite.next()); //다음 값을불러옴.
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
