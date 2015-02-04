package formatting;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class FormattingTest {
	public static void main(String[] args) {
		decimalFormatTest();
		dateFormatTest();
		Diy();
		

	}
	
	//���ڰ��� ����ȭ�� String���� ��ȯ.
	public static void decimalFormatTest(){
		//��ü ������ ���� ����.
		DecimalFormat df = new DecimalFormat("#,###.##");
		DecimalFormat df2 = new DecimalFormat("\u00A4 #,###"); // \(��ȭ)ǥ��
		DecimalFormat df3 = new DecimalFormat("#,###%"); // ���� *100 �ϰ� %ǥ��
		//�� ��ȯ
		double num = 23042129593.236;
		System.out.println(df.format(num));
		System.out.println(df2.format(num));
		System.out.println(df3.format(0.94));
	}
	//date ��ü�� ����ȭ�� String���� ��ȯ.
	public static void dateFormatTest(){
		//��ü ������ ���� ����.
		SimpleDateFormat sf = new SimpleDateFormat("yyyy�� MM�� dd�� E���� a HH�� mm�� ss.S��");
		SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd E���� a HH:mm:ss.S");
		//�� ��ȯ
		System.out.println(sf.format(new Date()));
		
		//GregorianCalendar�� ����ϱ� ���ؼ� date�� ��ȯ�Ͽ� ����ؾ���.
		GregorianCalendar gc = new GregorianCalendar();
		Date d = gc.getTime();
		System.out.println(sf2.format(d));
	}
	
	public static void Diy(){
		//������ Calendar��ü�� ������ ��, "��-��-��" �������� ����ϼ���.
		GregorianCalendar gc = new GregorianCalendar(1900,12,12);
		Date d = gc.getTime();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sf.format(d));
		
		//ù ������ ������ �Ͻø� ��/��/�� ��:�� ���Ϸ� ���.
		GregorianCalendar gc2 = new GregorianCalendar(2014,12,8,9,0);
		Date d2 = gc2.getTime();
		SimpleDateFormat sf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm E����");
		System.out.println(sf2.format(d2));
		
		//���� ������ �ִ� ���� int money ������ �ְ� �� ���� ���ڸ� ������ ���� ��ȭ ǥ�� �ؼ� ���
		DecimalFormat df = new DecimalFormat("\u00A4#,###"); // \(��ȭ)ǥ��
		System.out.println(df.format(10000));
		
		//���� �ѱ� ���� ���� �ݸ��� double ������ �ְ� %�� �ٿ� ���
		DecimalFormat df2 = new DecimalFormat("#,###.###%");
		System.out.println(df2.format(0.0212));
		
		
	}
}
