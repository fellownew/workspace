package generics.genericstest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class CollectionGenericsTest {
	public static void main(String[] args) {
		collectionTest();
		System.out.println("\n-------------------");
		mapTest();
	}

	public static void collectionTest() {
		HashSet<String> set = new HashSet<String>();
		set.add("abc");
		set.add("def");
		String f = "fff";
//		set.add(234);
		set.add(f);
		for(String s : set){
			System.out.print(s+"  ");
		}
		System.out.println("\n========");
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(314);
		al.add(2111);
//		al.add("abc");
		for(Integer o:al){
			System.out.print(o+" ");
		}
	}
	public static void mapTest(){
		HashMap<Integer,String> hm = new HashMap<Integer,String>();
		hm.put(1, "일");
		hm.put(2, "이");
//		hm.put("3", 3);
		String v = hm.get(2);
		System.out.println(v);
		Set<Integer> keys = hm.keySet();
		for(Integer i:keys){
			System.out.print(i+" ");
		}
		System.out.println("\n++++++++++++++++++++++++++++");
		Set<Entry<Integer, String>> ent = hm.entrySet();
		for(Entry e:ent){
			System.out.print(e+" ");
		}
		/* - 이렇게도 가능. -
		 * for(Entry<Integer,String> e:ent){
		 * Integer k = e.getKey();
		 * String v = e.getValue();
		 * System.out.println(k+" : "+v);
		 */
	}
}
