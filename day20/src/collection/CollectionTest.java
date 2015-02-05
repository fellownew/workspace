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
		// set : �ߺ��� ������� ����.- �ߺ����δ� equals(),hashCode()�� üũ, ���������� Object[]�� ����

		HashSet set1 = new HashSet();
		boolean flag = set1.add("�ȳ��ϼ���");
		System.out.println("�߰� �Ǿ��°�? " + (flag ? "����" : "����"));
		set1.add("��ö��");
		// ��� ���� Ȯ��
		System.out.println("set1�� ��� ���� : " + set1.size());
		set1.add("����");
		// �ߺ� ��� �߰� �Ұ�
		flag = set1.add("��ö��");
		System.out.println("�߰� �Ǿ��°�? " + (flag ? "����" : "����"));
		System.out.println("set1�� ��� ���� : " + set1.size());
		// ���� : remove(object) : boolean
		flag = set1.remove("��ö��");
		System.out.println("���� �Ǿ��°�? " + (flag ? "����" : "����"));
		System.out.println("set1�� ��� ���� : " + set1.size());
		flag = set1.remove("gdfesf");
		System.out.println("���� �Ǿ��°�? " + (flag ? "����" : "����"));
		System.out.println("set1�� ��� ���� : " + set1.size());

		// ��ȸ : contains(Object ��ȸ�� ��ü ) : boolean = �Ű������� ���� ��ü�� collection��
		// ������ �ִ��� ����
		flag = set1.contains("����");
		System.out.println("���ڰ� �ִ°�? " + (flag ? "����" : "����"));
		if (set1.contains("agdfef")) {
			flag = set1.remove("agdfef");
			System.out.println("���� �Ǿ��°�? " + (flag ? "����" : "����"));
		} else {
			System.out.println("�ش� ��Ҵ� set1�� �����ϴ�.");
		}
		// ���� : clear() - Collection(Set,List)�� ���� ��� ���(��ü)���� �����ϴ� �޼ҵ�.
		set1.clear();
		System.out.println("set1�� ��� ���� : " + set1.size());

		HashSet set2 = new HashSet();
		set2.add(new Integer(10));
		set2.add(new Double(20.53));
		set2.add(new Long(23423523L));
		System.out.println(set2.add(new Integer(10)));// �ߺ�- Wrapeer�� equlas()
														// �������̵� �Ǿ� ����.
		set2.add(2000); // int�� �ƴ� Integer
		set2.add('A'); // char�� �ƴ� Character
		System.out.println(set2.size());
		System.out.println("==���� for���� �̿��� set ��ȸ==");
		for (Object i : set2) {// �迭 �Ǵ� �÷����� ����.
			System.out.println(i);// �������� ����.
		}
	}

	public static void setTest2() {
		Product p1 = new Product("Id-1", "������", "���", 200000000);
		Product p2 = new Product("Id-1", "������", "���", 200000000);
		// set������ �ߺ����� üũ equals, hashcode ��� true�� ���;���.
		HashSet set = new HashSet();
		System.out.println(set.add(p1));
		System.out.println(set.add(p2));
		System.out.println(set.size());
	}

	public static void listTest1() {
		// List : ������ �ִ� collection(�߰��Ǵ� ��ü�� index�� ����. index�� 0���� ����.
		ArrayList l = new ArrayList(100); // �ʱ� ��ü ������ ����, 100�� ������ �ڵ����� �þ
		ArrayList list = new ArrayList();
		list.add("abc");
		list.add("bcd");
		list.add("cde");
		list.add("def");
		list.add("efg");
		System.out.println(list + "  �� ���� : " + list.size());
		printList(list);
		//Ư�� �ε��� �� ��ȸ
		System.out.println(list.get(2));
		//get�� �̿��Ͽ� ��ȸ�Ҷ� ������ �Ѿ�� index�� ��ȸ�� �� IndexOutOfBoundsExceprion ���� ���� �߻�
		list.add(3,"de");
		printList(list);
		//list.add(10,"jk"); //�߰��� �� index�� ���⵵�� �����ϸ� ���� �߻�. 
		System.out.println(list.remove("de"));
		printList(list);
		System.out.println(list.remove(3));
		printList(list);
		System.out.println(list.set(1, "ccc"));
		printList(list);
	}

	public static void printList(ArrayList list) {
		// �Ű������� ���� Lsit��ü�� 0�� idx���� �� ������ŭ �ݺ��ϸ鼭 �� ���
		for (int i = 0; i < list.size(); i++) {
			// i index�� �ִ� ��ü ��ȸ
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		// ���� for�����ε� ����.
		for (Object o : list) {
			System.out.print(o + " ");
		}
		System.out.println();
	}
	public static void listTest2() {
		ArrayList list = new ArrayList();
		DecimalFormat df = new DecimalFormat("\u00A4#,###.##��");
		list.add(new Product("Id-1","��ǰ1","����ȸ��",5990000));
		list.add(new Product("Id-2","��ǰ2","����ȸ��",250000));
		list.add(new Product("Id-3","��ǰ3","������ȸ��",1000000));
		list.add(new Product("Id-4","��ǰ4","������ȸ��",150000));
		list.add(new Product("Id-5","��ǰ5","����ȸ��",100000000));
		
		System.out.println(((Product)list.get(1)).getProductName());
		int sum=0;
		for(int i = 0 ; i<list.size();i++){
			sum+=(((Product)list.get(i)).getPrice());
		}
		System.out.println("��� ��ǰ�� ��� : " +df.format(sum/list.size()));
		
		//list���� productID�� "Id-3"�� ��ǰ�� ã�� pr2������ �ְ� �� ��ǰ�� ��ǰ��� �����縦 ���.
		Product pr2 = null;
		for(int i = 0 ; i<list.size();i++){
			if(((Product)list.get(i)).getProductId().equals("Id-5")){
				pr2=(Product)list.get(i);
				break;
			}
		}
		System.out.println(pr2.getProductName()+" "+pr2.getProductMaker());
		
		//����° ��ǰ list���� ���� �� ��ü ���� ���
		System.out.println(list.remove(2));
		
		
	}
}