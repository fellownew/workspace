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
		list.add(new Product("p-101","��Ʈ��","�Ｚ",2300000));
		
		Collections.sort(list);
		System.out.println(list);
	}

	public static void listSorting() {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("ȫ�浿");
		list.add("�迵��");
		list.add("��ö��");
		list.add("�ֿ���");
		list.add("�Ӳ���");
		list.add("���μ�");
		list.add("�ѻ��");
		System.out.println(list); // toString �������̵� �Ǿ� ����. [e.toString(),e.toString(),......]
		Collections.sort(list,new StringDecendingComparator());// ���� ���ڷ� ���� list�� ������ ���·� ����� �ش�.
		System.out.println(list);
	}

	public static void setSorting() {
		TreeSet<String> set = new TreeSet<String>();
		set.add("ȫ�浿");
		set.add("�迵��");
		set.add("��ö��");
		set.add("�ֿ���");
		set.add("�Ӳ���");
		set.add("���μ�");
		set.add("�ѻ��");
		System.out.println(set);
	}

	public static void mapSorting() {
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		map.put(1, "ȫ�浿");
		map.put(2, "�迵��");
		map.put(3, "��ö��");
		map.put(4, "�ֿ���");
		map.put(5, "�Ӳ���");
		map.put(6, "���μ�");
		map.put(7, "�ѻ��");
		System.out.println(map);

	}
}
