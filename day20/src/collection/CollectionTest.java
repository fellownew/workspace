package collection;

import java.util.HashSet;

public class CollectionTest {
	public static void main(String[] args) {
		setTest();
	}

	public static void setTest() {
		//set : �ߺ��� ������� ����.- �ߺ����δ� equals(),hashCode()�� üũ, ���������� Object[]�� ����
		
		HashSet set1 = new HashSet();
		boolean flag = set1.add("�ȳ��ϼ���");
		System.out.println("�߰� �Ǿ��°�? "+(flag?"����":"����"));
		set1.add("��ö��");
		//��� ���� Ȯ��
		System.out.println("set1�� ��� ���� : " +set1.size());
		set1.add("����");
		//�ߺ� ��� �߰� �Ұ�
		flag = set1.add("��ö��");
		System.out.println("�߰� �Ǿ��°�? "+(flag?"����":"����"));
		System.out.println("set1�� ��� ���� : " +set1.size());
		//���� : remove(object) : boolean
		flag = set1.remove("��ö��");
		System.out.println("���� �Ǿ��°�? "+(flag?"����":"����"));
		System.out.println("set1�� ��� ���� : " +set1.size());
		flag = set1.remove("gdfesf");
		System.out.println("���� �Ǿ��°�? "+(flag?"����":"����"));
		System.out.println("set1�� ��� ���� : " +set1.size());
		
		//��ȸ : contains(Object ��ȸ�� ��ü ) : boolean = �Ű������� ���� ��ü�� collection�� ������ �ִ��� ���� 
		flag = set1.contains("����");
		System.out.println("���ڰ� �ִ°�? "+(flag?"����":"����"));
		if(set1.contains("agdfef")){
			flag = set1.remove("agdfef");
			System.out.println("���� �Ǿ��°�? "+(flag?"����":"����"));
		}else{
			System.out.println("�ش� ��Ҵ� set1�� �����ϴ�.");
		}
		//���� : clear() - Collection(Set,List)�� ���� ��� ���(��ü)���� �����ϴ� �޼ҵ�.
		set1.clear();
		System.out.println("set1�� ��� ���� : " +set1.size());
		
		
		
		HashSet set2 = new HashSet();
		set2.add(new Integer(10));
		set2.add(new Double(20.53));
		set2.add(new Long(23423523L));
		System.out.println(set2.add(new Integer(10)));//�ߺ�- Wrapeer�� equlas() �������̵� �Ǿ� ����.
		set2.add(2000); // int�� �ƴ� Integer
		set2.add('A'); // char�� �ƴ� Character
		System.out.println(set2.size());
		System.out.println("==���� for���� �̿��� set ��ȸ==");
		for(Object i :set2){//�迭 �Ǵ� �÷����� ����.
			System.out.println(i);//�������� ����.
		}
	}
}
