package collection;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;

import collection.vo.Product;

public class CollectionTest {
	public static void main(String[] args) {
		setTest();
		System.out.println("--------------------");
		setTest2();
		System.out.println("============");
		listTest1();
		System.out.println("//////////////////////////");
		listTest2();
	}

	public static void setTest() {
		// set : 중복을 허용하지 않음.- 중복여부는 equals(),hashCode()로 체크, 내부적으로 Object[]를 관리

		HashSet set1 = new HashSet();
		boolean flag = set1.add("안녕하세요");
		System.out.println("추가 되었는가? " + (flag ? "성공" : "실패"));
		set1.add("김철수");
		// 요소 개수 확인
		System.out.println("set1내 요소 개수 : " + set1.size());
		set1.add("사자");
		// 중복 요소 추가 불가
		flag = set1.add("김철수");
		System.out.println("추가 되었는가? " + (flag ? "성공" : "실패"));
		System.out.println("set1내 요소 개수 : " + set1.size());
		// 삭제 : remove(object) : boolean
		flag = set1.remove("김철수");
		System.out.println("삭제 되었는가? " + (flag ? "성공" : "실패"));
		System.out.println("set1내 요소 개수 : " + set1.size());
		flag = set1.remove("gdfesf");
		System.out.println("삭제 되었는가? " + (flag ? "성공" : "실패"));
		System.out.println("set1내 요소 개수 : " + set1.size());

		// 조회 : contains(Object 조회할 객체 ) : boolean = 매개변수로 받은 객체를 collection이
		// 가지고 있는지 여부
		flag = set1.contains("사자");
		System.out.println("사자가 있는가? " + (flag ? "성공" : "실패"));
		if (set1.contains("agdfef")) {
			flag = set1.remove("agdfef");
			System.out.println("삭제 되었는가? " + (flag ? "성공" : "실패"));
		} else {
			System.out.println("해당 요소는 set1에 없습니다.");
		}
		// 삭제 : clear() - Collection(Set,List)가 가진 모든 요소(객체)들을 삭제하는 메소드.
		set1.clear();
		System.out.println("set1내 요소 개수 : " + set1.size());

		HashSet set2 = new HashSet();
		set2.add(new Integer(10));
		set2.add(new Double(20.53));
		set2.add(new Long(23423523L));
		System.out.println(set2.add(new Integer(10)));// 중복- Wrapeer는 equlas()
														// 오버라이드 되어 있음.
		set2.add(2000); // int가 아닌 Integer
		set2.add('A'); // char가 아닌 Character
		System.out.println(set2.size());
		System.out.println("==향상된 for문을 이용한 set 조회==");
		for (Object i : set2) {// 배열 또는 컬렉션이 가능.
			System.out.println(i);// 순서따윈 없음.
		}
	}

	public static void setTest2() {
		Product p1 = new Product("Id-1", "좋은차", "페라리", 200000000);
		Product p2 = new Product("Id-1", "좋은차", "페라리", 200000000);
		// set에서의 중복여부 체크 equals, hashcode 모두 true로 나와야함.
		HashSet set = new HashSet();
		System.out.println(set.add(p1));
		System.out.println(set.add(p2));
		System.out.println(set.size());
	}

	public static void listTest1() {
		// List : 순서가 있는 collection(추가되는 객체에 index를 붙임. index는 0부터 시작.
		ArrayList l = new ArrayList(100); // 초기 객체 개수를 지정, 100개 넘으면 자동으로 늘어남
		ArrayList list = new ArrayList();
		list.add("abc");
		list.add("bcd");
		list.add("cde");
		list.add("def");
		list.add("efg");
		System.out.println(list + "  총 개수 : " + list.size());
		printList(list);
		//특정 인덱스 값 조회
		System.out.println(list.get(2));
		//get을 이용하여 조회할때 범위를 넘어서는 index를 조회할 시 IndexOutOfBoundsExceprion 실행 오류 발생
		list.add(3,"de");
		printList(list);
		//list.add(10,"jk"); //중간에 빈 index가 생기도록 삽입하면 오류 발생. 
		System.out.println(list.remove("de"));
		printList(list);
		System.out.println(list.remove(3));
		printList(list);
		System.out.println(list.set(1, "ccc"));
		printList(list);
	}

	public static void printList(ArrayList list) {
		// 매개변수로 받은 Lsit객체의 0번 idx에서 총 개수만큼 반복하면서 값 출력
		for (int i = 0; i < list.size(); i++) {
			// i index에 있는 객체 조회
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		// 향상된 for문으로도 가능.
		for (Object o : list) {
			System.out.print(o + " ");
		}
		System.out.println();
	}
	public static void listTest2() {
		ArrayList list = new ArrayList();
		DecimalFormat df = new DecimalFormat("\u00A4#,###.##원");
		list.add(new Product("Id-1","상품1","좋은회사",5990000));
		list.add(new Product("Id-2","상품2","좋은회사",250000));
		list.add(new Product("Id-3","상품3","더좋은회사",1000000));
		list.add(new Product("Id-4","상품4","안좋은회사",150000));
		list.add(new Product("Id-5","상품5","나쁜회사",100000000));
		
		System.out.println(((Product)list.get(1)).getProductName());
		int sum=0;
		for(int i = 0 ; i<list.size();i++){
			sum+=(((Product)list.get(i)).getPrice());
		}
		System.out.println("모든 상품의 평균 : " +df.format(sum/list.size()));
		
		//list에서 productID가 "Id-3"인 제품을 찾아 pr2변수에 넣고 그 제품의 제품명과 제조사를 출력.
		Product pr2 = null;
		for(int i = 0 ; i<list.size();i++){
			if(((Product)list.get(i)).getProductId().equals("Id-5")){
				pr2=(Product)list.get(i);
				break;
			}
		}
		System.out.println(pr2.getProductName()+" "+pr2.getProductMaker());
		
		//세번째 상품 list에서 제거 후 전체 정보 출력
		System.out.println(list.remove(2));
		
		
	}
}