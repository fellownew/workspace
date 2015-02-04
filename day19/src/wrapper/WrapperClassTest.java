package wrapper;

public class WrapperClassTest {
	public static void main(String[] args) {
		boxingUnboxingTest();
		System.out.println("==========");
		autoBoxingUnboxingTest();
		System.out.println("------------------");
		stringToPrimitive();
	}

	public static void boxingUnboxingTest() {
		// WrapperŬ�������� toString(), equals(), hashcode() ��� Override �Ǿ��ִ�.
		// boxing : primitive -> Wrapper
		Integer in1 = new Integer(20);
		Integer in2 = new Integer("20"); // ��ȯ ���� ���ڿ��� �־����.
		Double d = new Double(20.5);
		System.out.println(in1);
		// Unboxing : Wrapper -> primitive
		int i = in1.intValue();
		int i2 = in2.intValue();
		System.out.println(i);
		System.out.println(i2);
	}

	public static void autoBoxingUnboxingTest() {
		Integer in1 = 30;
		Integer in2 = 35;
		Double d = 30.5;
		System.out.println(in1);
		int i = in1;
		int i2 = in2;
		double dd = d;
		System.out.println(in1);
		System.out.println(i);
		System.out.println(dd);
		Object o = 652;
		int oi = (int)o;
		
	}
	
	public static void stringToPrimitive(){
		//String -> primitive : WrapperŬ����.parseXXX("��");	
		String s1 = "646346";
		String s2 = "false";
		String s3 = "323.46";
		int i = Integer.parseInt(s1);
		boolean b = Boolean.parseBoolean(s2);
		double d = Double.parseDouble(s3);
		System.out.println(s1+"  "+s2+"  "+s3);
		System.out.println(i+"  "+b+"  "+d);
//		int i2 = Integer.parseInt(s2); //������ ������ �ȳ��� ������ �� ��ȯ�� �Ұ��ϱ⶧���� ���� ������ �߻���.
	}
}
