package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		mapTest1();
		
		
	}
	public static void mapTest1(){
		//Map : key(Object)-value(Object)  쌍으로 모아 관리하는 컬렉션
		//HashMap, HashTable,TreeMap(key기준 정렬)
		HashMap hm = new HashMap();
		//추가 : put
		hm.put("name", "홍길동");
		hm.put("age",20);
		hm.put("address", "서울");
		hm.put("weight", 73.5);
		
		//조회 : get
		Object o1 = hm.get("name");
		System.out.println(o1+"-"+hm.get("age"));
		
		//put으로 변경도 됨.
		Object o2 = hm.put("age",21);
		System.out.println("전 나이"+o2+", 후 나이"+hm.get("age"));
		
		//삭제 : remove
		Object o3 = hm.remove("age");
		System.out.println(o3+"..."+(hm.get("age")!=null?hm.get("age"):"age가 존재하지않습니다."));
		
		//특정 객체가 map의 key나 value로 존재하는지 체크
		System.out.println(hm.containsKey("name")?hm.get("name")+"이 있습니다.":"없습니다.");
		System.out.println(hm.containsValue("서울")?hm.get("address")+"이 있습니다.":"없습니다.");	
		
		System.out.println("-------------------------------------");
		printAllElements(hm);
		printAllElements2(hm);

	}
	
	
	public static void printAllElements(Map map){
		Set keys = map.keySet();//map의 키들을 set으로 복사.
		for(Object key:keys){
			System.out.println(key+" - "+map.get(key));//키와 그 키에 있는 값을 for문으로 출력
		}
	}
	public static void printAllElements2(Map map){
		Set entrys = map.entrySet();//key와 value를 함께 가지고 있는 녀석으로 복사.
		for(Object o:entrys){
			System.out.println(o);
		//	Entry entry = (Entry)o;
		//	System.out.println(entry.getKey()+" : "+entry.getValue());
		}
	}
}
