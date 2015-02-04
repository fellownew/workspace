package collection;

import java.util.HashSet;

public class CollectionTest {
	public static void main(String[] args) {
		setTest();
	}

	public static void setTest() {
		//set : 중복을 허용하지 않음.- 중복여부는 equals(),hashCode()로 체크, 내부적으로 Object[]를 관리
		
		HashSet set1 = new HashSet();
		boolean flag = set1.add("안녕하세요");
		System.out.println("추가 되었는가? "+(flag?"성공":"실패"));
		set1.add("김철수");
		//요소 개수 확인
		System.out.println("set1내 요소 개수 : " +set1.size());
		set1.add("사자");
		//중복 요소 추가 불가
		flag = set1.add("김철수");
		System.out.println("추가 되었는가? "+(flag?"성공":"실패"));
		System.out.println("set1내 요소 개수 : " +set1.size());
		//삭제 : remove(object) : boolean
		flag = set1.remove("김철수");
		System.out.println("삭제 되었는가? "+(flag?"성공":"실패"));
		System.out.println("set1내 요소 개수 : " +set1.size());
		flag = set1.remove("gdfesf");
		System.out.println("삭제 되었는가? "+(flag?"성공":"실패"));
		System.out.println("set1내 요소 개수 : " +set1.size());
		
		//조회 : contains(Object 조회할 객체 ) : boolean = 매개변수로 받은 객체를 collection이 가지고 있는지 여부 
		flag = set1.contains("사자");
		System.out.println("사자가 있는가? "+(flag?"성공":"실패"));
		if(set1.contains("agdfef")){
			flag = set1.remove("agdfef");
			System.out.println("삭제 되었는가? "+(flag?"성공":"실패"));
		}else{
			System.out.println("해당 요소는 set1에 없습니다.");
		}
		//삭제 : clear() - Collection(Set,List)가 가진 모든 요소(객체)들을 삭제하는 메소드.
		set1.clear();
		System.out.println("set1내 요소 개수 : " +set1.size());
		
		
		
		HashSet set2 = new HashSet();
		set2.add(new Integer(10));
		set2.add(new Double(20.53));
		set2.add(new Long(23423523L));
		System.out.println(set2.add(new Integer(10)));//중복- Wrapeer는 equlas() 오버라이드 되어 있음.
		set2.add(2000); // int가 아닌 Integer
		set2.add('A'); // char가 아닌 Character
		System.out.println(set2.size());
		System.out.println("==향상된 for문을 이용한 set 조회==");
		for(Object i :set2){//배열 또는 컬렉션이 가능.
			System.out.println(i);//순서따윈 없음.
		}
	}
}
