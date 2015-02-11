package collection.etc;

import java.util.Comparator;

//���ڿ��� ������������ ���ĵǵ��� ó���� Comparator.
//1. java.util.Comparator<E> implements
//2. compareM(E o1, E o2) : int
public class StringDecendingComparator implements Comparator<String> {

	public int compare(String s1, String s2) {
		//s1: ���� ��ü(����), s2: �� ���
		//���� : 0, ��ü>��� : ���, ��ü<��� : ����
		return s1.compareTo(s2)*-1;
		//s1.compareTo(s2)�̸� �������� ����.
		//s2.compareTo(s1)���� �����ϸ� ��������.
	}
}
