package collection.etc;

import java.util.Comparator;

//문자열을 내림차순으로 정렬되도록 처리할 Comparator.
//1. java.util.Comparator<E> implements
//2. compareM(E o1, E o2) : int
public class StringDecendingComparator implements Comparator<String> {

	public int compare(String s1, String s2) {
		//s1: 비교의 주체(기준), s2: 비교 대상
		//같다 : 0, 주체>대상 : 양수, 주체<대상 : 음수
		return s1.compareTo(s2)*-1;
		//s1.compareTo(s2)이면 오름차순 개념.
		//s2.compareTo(s1)으로 리턴하면 내림차순.
	}
}
