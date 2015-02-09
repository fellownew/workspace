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
		//Map : key(Object)-value(Object)  ������ ��� �����ϴ� �÷���
		//HashMap, HashTable,TreeMap(key���� ����)
		HashMap hm = new HashMap();
		//�߰� : put
		hm.put("name", "ȫ�浿");
		hm.put("age",20);
		hm.put("address", "����");
		hm.put("weight", 73.5);
		
		//��ȸ : get
		Object o1 = hm.get("name");
		System.out.println(o1+"-"+hm.get("age"));
		
		//put���� ���浵 ��.
		Object o2 = hm.put("age",21);
		System.out.println("�� ����"+o2+", �� ����"+hm.get("age"));
		
		//���� : remove
		Object o3 = hm.remove("age");
		System.out.println(o3+"..."+(hm.get("age")!=null?hm.get("age"):"age�� ���������ʽ��ϴ�."));
		
		//Ư�� ��ü�� map�� key�� value�� �����ϴ��� üũ
		System.out.println(hm.containsKey("name")?hm.get("name")+"�� �ֽ��ϴ�.":"�����ϴ�.");
		System.out.println(hm.containsValue("����")?hm.get("address")+"�� �ֽ��ϴ�.":"�����ϴ�.");	
		
		System.out.println("-------------------------------------");
		printAllElements(hm);
		printAllElements2(hm);

	}
	
	
	public static void printAllElements(Map map){
		Set keys = map.keySet();//map�� Ű���� set���� ����.
		for(Object key:keys){
			System.out.println(key+" - "+map.get(key));//Ű�� �� Ű�� �ִ� ���� for������ ���
		}
	}
	public static void printAllElements2(Map map){
		Set entrys = map.entrySet();//key�� value�� �Բ� ������ �ִ� �༮���� ����.
		for(Object o:entrys){
			System.out.println(o);
		//	Entry entry = (Entry)o;
		//	System.out.println(entry.getKey()+" : "+entry.getValue());
		}
	}
}
