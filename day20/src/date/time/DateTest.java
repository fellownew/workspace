package date.time;

import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		Date d1 = new Date();// no-arg : 실행 시점의 일시
		System.out.println(d1);
		System.out.println(d1.getYear());// 1900 차이.
		System.out.println(d1.getMonth());// 0월~11월
		System.out.println(d1.getDate());
		System.out.println(d1.getDay());// 일~토 : 0~6요일
		System.out.println(d1.getHours() + d1.getMinutes() + d1.getSeconds());
		Date d2 = new Date(115, 3, 7, 20, 20, 20);
		System.out.println(d2);
		Date d3 = new Date(1423014800000l);
		System.out.println(d3);
		Date d4 = new Date();
		System.out.println(d4);
	}
}
