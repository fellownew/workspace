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
	
	//숫자값을 형식화된 String으로 변환.
	public static void decimalFormatTest(){
		//객체 생성시 형식 지정.
		DecimalFormat df = new DecimalFormat("#,###.##");
		DecimalFormat df2 = new DecimalFormat("\u00A4 #,###"); // \(원화)표시
		DecimalFormat df3 = new DecimalFormat("#,###%"); // 값에 *100 하고 %표시
		//값 변환
		double num = 23042129593.236;
		System.out.println(df.format(num));
		System.out.println(df2.format(num));
		System.out.println(df3.format(0.94));
	}
	//date 객체를 형식화된 String으로 변환.
	public static void dateFormatTest(){
		//객체 생성시 형식 지정.
		SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a HH시 mm분 ss.S초");
		SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd E요일 a HH:mm:ss.S");
		//값 변환
		System.out.println(sf.format(new Date()));
		
		//GregorianCalendar를 사용하기 위해선 date로 변환하여 사용해야함.
		GregorianCalendar gc = new GregorianCalendar();
		Date d = gc.getTime();
		System.out.println(sf2.format(d));
	}
	
	public static void Diy(){
		//생일을 Calendar객체로 생성한 뒤, "년-월-일" 형식으로 출력하세요.
		GregorianCalendar gc = new GregorianCalendar(1900,12,12);
		Date d = gc.getTime();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sf.format(d));
		
		//첫 수업이 시작한 일시를 년/월/일 시:분 요일로 출력.
		GregorianCalendar gc2 = new GregorianCalendar(2014,12,8,9,0);
		Date d2 = gc2.getTime();
		SimpleDateFormat sf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm E요일");
		System.out.println(sf2.format(d2));
		
		//현재 가지고 있는 돈을 int money 변수에 넣고 그 값을 세자리 단위로 끊고 원화 표시 해서 출력
		DecimalFormat df = new DecimalFormat("\u00A4#,###"); // \(원화)표시
		System.out.println(df.format(10000));
		
		//현재 한국 은행 기준 금리를 double 변수에 넣고 %를 붙여 출력
		DecimalFormat df2 = new DecimalFormat("#,###.###%");
		System.out.println(df2.format(0.0212));
		
		
	}
}
