package collection.etc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.TreeSet;

import collection.vo.Customer;

public class CustomerSorting {
	public static void main(String[] args) {
		sort1();
		System.out.println("===============================================");
		sort2();
	}

	// ArrayList에 고객 n개의 객체를 넣고 id 오름차순으로 정렬되도록 처리 후 출력
	public static void sort1() {
		ArrayList<Customer> al = new ArrayList<Customer>();
		al.add(new Customer("id-5", "1111","김영수",  "02-111-2222", "kys@kosta.or.kr", 40000));
		al.add(new Customer("id-2", "4444","이미영", "031-222-3333", "lmy@kosta.or.kr", 5500));
		al.add(new Customer("id-3", "2222","최우수",  "010-555-1212","cws@kosta.or.kr", 350000));
		al.add(new Customer("id-4", "3333","이미영",  "010-3434-5656", "lmy@kosta.or.kr", 2700));
		al.add(new Customer("id-1", "5555","이미영",  "031-532-6421", "Rmy@kosta.or.kr",550));
		al.add(new Customer("id-7", "6666","장경수",  "010-9011-3222", "cks@kosta.or.kr", 66000));
		al.add(new Customer("id-6", "7777","홍길범",  "010-5434-6533", "hkb@kosta.or.kr", 57000));
		Collections.sort(al);
		printAll(al);


	}

	// TreeSet에 고객 n개의 객체를 넣고 고객명(name) 내림차순으로 정렬되도록 추가 후 출력
	public static void sort2() {
		TreeSet<Customer> ts = new TreeSet<Customer>(new NameSortComparator());
		ts.add(new Customer("id-1", "1111","김영수",  "02-111-2222", "kys@kosta.or.kr", 40000));
		ts.add(new Customer("id-2", "4444","이미영", "031-222-3333", "lmy@kosta.or.kr", 5500));
		ts.add(new Customer("id-3", "2222","최우수",  "010-555-1212","cws@kosta.or.kr", 350000));
		ts.add(new Customer("id-4", "6666","장경수",  "010-9011-3222", "cks@kosta.or.kr", 66000));
		ts.add(new Customer("id-5", "7777","홍길범",  "010-5434-6533", "hkb@kosta.or.kr", 57000));
		ts.add(new Customer("id-6", "7778","홍길동",  "010-5434-6534", "hsb@kosta.or.kr", 58000));
		ts.add(new Customer("id-7", "9998","김미영",  "031-222-3253", "ged@kosta.or.kr", 477000));
		printAll(ts);
	}
	public static void printAll(Collection<Customer> c){
		for(Customer o1:c){
			System.out.println(o1);
		}
	}
}