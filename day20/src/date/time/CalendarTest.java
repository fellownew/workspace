package date.time;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarTest {
	public static void main(String[] args) {
		// Calendar c = new Calendar(); // Calendar�� �߻�Ŭ����
		GregorianCalendar gc = new GregorianCalendar(); // no-arg : ���� ������ �Ͻ�
		System.out.println(gc.getTime());
		// �Ӽ� ��ȸ �޼ҵ� - get(int ��ȸ�׸�) : int - > ��ȸ �׸��� Calendar�� public static final ������ ���ǵǾ� ����.
		System.out.print(gc.get(Calendar.YEAR) + "�� "+ gc.get(Calendar.MONTH) + 1 + "�� " + gc.get(Calendar.DATE)+ "�� ");
		System.out.println(gc.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY ? "������"
						: gc.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY ? "ȭ����"
								: gc.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY ? "������"
										: gc.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY ? "�����"
												: gc.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY ? "�ݿ���"
														: gc.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ? "�����"
																: "�Ͽ���");
		System.out.print(gc.get(Calendar.AM_PM) == Calendar.AM ? "���� " : "���� ");// 0:AM, 1:PM
		System.out.println(gc.get(Calendar.HOUR) + "�� "+ gc.get(Calendar.MINUTE) + "�� " + gc.get(Calendar.SECOND)+ "��");
		//HOUR�� 12��, HOUR_OF_DAY�� 24��
		System.out.println("[" + gc.get(Calendar.MILLISECOND) + "]");
		//add(int �߰��ʵ�, int��) : �Ͻø� ����, �߰��ʵ� : ������ �Ͻ�, ��: ������ ��
		GregorianCalendar gc1 = new GregorianCalendar();
		gc1.add(Calendar.YEAR, 100);
		gc1.add(Calendar.DATE,200);
		System.out.println(gc1.getTime());
		
		//Ư�� �⵵�� ���� ����. GC��ü.isLeapYear(int �⵵) : boolean
		System.out.println(gc1.isLeapYear(2012));
		
	}
}
