package date.time;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarTest {
	public static void main(String[] args) {
		// Calendar c = new Calendar(); // Calendar는 추상클래스
		GregorianCalendar gc = new GregorianCalendar(); // no-arg : 실행 시점의 일시
		System.out.println(gc.getTime());
		// 속성 조회 메소드 - get(int 조회항목) : int - > 조회 항목은 Calendar에 public static final 변수로 정의되어 있음.
		System.out.print(gc.get(Calendar.YEAR) + "년 "+ gc.get(Calendar.MONTH) + 1 + "월 " + gc.get(Calendar.DATE)+ "일 ");
		System.out.println(gc.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY ? "월요일"
						: gc.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY ? "화요일"
								: gc.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY ? "수요일"
										: gc.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY ? "목요일"
												: gc.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY ? "금요일"
														: gc.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ? "토요일"
																: "일요일");
		System.out.print(gc.get(Calendar.AM_PM) == Calendar.AM ? "오전 " : "오후 ");// 0:AM, 1:PM
		System.out.println(gc.get(Calendar.HOUR) + "시 "+ gc.get(Calendar.MINUTE) + "분 " + gc.get(Calendar.SECOND)+ "초");
		//HOUR는 12시, HOUR_OF_DAY는 24시
		System.out.println("[" + gc.get(Calendar.MILLISECOND) + "]");
		//add(int 추가필드, int값) : 일시를 증감, 추가필드 : 증감할 일시, 값: 증감할 값
		GregorianCalendar gc1 = new GregorianCalendar();
		gc1.add(Calendar.YEAR, 100);
		gc1.add(Calendar.DATE,200);
		System.out.println(gc1.getTime());
		
		//특정 년도의 윤년 여부. GC객체.isLeapYear(int 년도) : boolean
		System.out.println(gc1.isLeapYear(2012));
		
	}
}
