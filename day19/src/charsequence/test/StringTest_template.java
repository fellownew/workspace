package charsequence.test;
public class StringTest_template {
	public static void main(String[] args) {
		String s1 = "abcde";
		String s2 = new String("abcde");
		String s3 = "ABCDE";

		int strLength = s1.length();// ���ڼ� ��ȸ
		System.out.println(strLength);// ���ڼ�

		System.out.println("s1 == s2 : "+(s1 == s2)); //s1�� s2�� ��
		System.out.println("s1.equals(s2) : "+s1.equals(s2)); //s1�� s2�� equals�� ��
		System.out.println("s1.equals(s3) : "+s1.equals(s3)); //s1�� s3�� equals�� ��
		
		System.out.println("s1.equalsIgnoreCase(s3) : "+s1.equalsIgnoreCase(s3)); //s1�� s3�� ��ҹ��� ���� ��
		
		boolean flag = s1.startsWith("ab"); // s1 �պκ��� ab�� �����ϴ°�?
		System.out.println("s1.startsWith(\"ab\") : "+flag);
		System.out.println("s1.endsWith(\"ef\") : "+s1.endsWith("ef")); // s1�� ������ �κ��� ef�� �����°�?
		
		
		String s4 = "abc abc abcdef";
		int idx = s4.indexOf("a");
		System.out.println("s4.indexOf(\"a\") : "+idx); //a�� ���°���� �����°�
		System.out.println("s4.indexOf(\" abc\") : "+s4.indexOf(" abc"));//" abc���°���� �����°� (���� ����)

		System.out.println("s4.lastIndexOf(\"a\") : "+s4.lastIndexOf("a"));//���� ������a�� ���°�ΰ�?
		System.out.println("s4.lastIndexOf(\" abc\") : "+s4.lastIndexOf(" abc"));//���� ������ " abc"�� ���°�ΰ�?
		System.out.println("s4.indexOf(\"a\", 2) : "+s4.indexOf("a", 2));//�ι�° ���ں��� �����Ͽ� ������ a�� ���°�ΰ�?

		char c = s4.charAt(5);
		System.out.println("s4.charAt(5) : "+c);//s4�� 5��° ���ڴ� �����ΰ�?
		System.out.println("s4.length()-1 : "+(s4.length()-1));//s4�� ������ ���ڴ� �����ΰ�?
		String s5 = "�ȳ��ϼ���. Hello. �ݰ����ϴ�.";
		String ss = s5.substring(14);//14��°���� ���.
		System.out.println("s5.substring(14) : "+ss);
		System.out.println("s5.substring(7, 12) : "+s5.substring(7, 12)); // 7��°���� 12-1��°���� ���

		ss = s3.toLowerCase();
		System.out.println(s3+","+ss);//s3�� �ҹ��ڷ� �����Ͽ� ���
		ss = s1.toUpperCase();
		System.out.println(s1+","+ss);//s1�� �빮�ڷ� �����Ͽ� ���
		
		String s6 = "ababaaabb";
		ss = s6.replace('a', 'k');
		System.out.println(s6+","+ss); //s6������ a�� ��� k�� ����
		
		ss = s5.replaceAll("Hello", "���");
		System.out.println(s5+","+ss);//s5������ Hello�� ��� ��η� ����
		
		String s7 = "���.��.��,����,����,�޷�,�ٳ���";
		String [] fruit = s7.split("\\."); // . �� �������� ��ĭ ������(����)
		System.out.println("------split() : ���ϵ�----");
		for(String str : fruit){
			System.out.println(str);
		}
	}
}
//StringTest.java
