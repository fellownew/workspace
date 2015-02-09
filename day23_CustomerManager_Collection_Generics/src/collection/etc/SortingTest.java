package collection.etc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
import java.util.TreeSet;

import collection.vo.Product;

public class SortingTest {
	public static void main(String[] args) {
		System.out.println("ArrayList Sorting");
		listSorting();
		System.out.println("TreeSetSorting");
		setSorting();
		System.out.println("TreeMapSorting");
		mapSorting();
		System.out.println("ProductSorting");
		productSorting();
	}
	
	public static void productSorting(){
		ArrayList<Product> list = new ArrayList<Product>();
		list.add(new Product("p-001","TV","LG",300000));
		list.add(new Product("p-020","COMPUTER","HP",1200000));
		list.add(new Product("p-045","CPU","Intel",200000));
		list.add(new Product("p-101","³ëÆ®ºÏ","»ï¼º",2300000));
		
		Collections.sort(list);
		System.out.println(list);
	}

	public static void listSorting() {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("È«±æµ¿");
		list.add("±è¿µ¼ö");
		list.add("±èÃ¶¼ö");
		list.add("ÃÖ¿µÈñ");
		list.add("ÀÓ²©Á¤");
		list.add("À¯¹Î¼ö");
		list.add("ÇÑ»ó¼ö");
		System.out.println(list); // toString ¿À¹ö¶óÀÌµù µÇ¾î ÀÖÀ½. [e.toString(),e.toString(),......]
		Collections.sort(list,new StringDecendingComparator());// Àü´Þ ÀÎÀÚ·Î ¹ÞÀº list¸¦ Á¤·ÄÇÑ »óÅÂ·Î ¸¸µé¾î ÁØ´Ù.
		System.out.println(list);
	}

	public static void setSorting() {
		TreeSet<String> set = new TreeSet<String>();
		set.add("È«±æµ¿");
		set.add("±è¿µ¼ö");
		set.add("±èÃ¶¼ö");
		set.add("ÃÖ¿µÈñ");
		set.add("ÀÓ²©Á¤");
		set.add("À¯¹Î¼ö");
		set.add("ÇÑ»ó¼ö");
		System.out.println(set);
	}

	public static void mapSorting() {
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		map.put(1, "È«±æµ¿");
		map.put(2, "±è¿µ¼ö");
		map.put(3, "±èÃ¶¼ö");
		map.put(4, "ÃÖ¿µÈñ");
		map.put(5, "ÀÓ²©Á¤");
		map.put(6, "À¯¹Î¼ö");
		map.put(7, "ÇÑ»ó¼ö");
		System.out.println(map);

	}
}
