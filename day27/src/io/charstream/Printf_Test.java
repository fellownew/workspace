package io.charstream;

import java.io.IOException;
import java.io.PrintWriter;

public class Printf_Test {
/*
 * PrintWriter, PrintStream�� �ִ� println(), print(), printf()�߿�
 * printf()�� jdk1.5�� �߰��� ������ printf(String format, Object... args)�̴�. 
 * format�� ���ִ� �������� ��ȯ���ڸ� �̿��Ͽ� ����ȭ�Ͽ� �������ָ�
 * args�� �������ڷ� ��ȯ���ڿ� �� ���� ������� ����Ѵ�.
 * format���� ����� �ֿ� ��ȯ ���ڴ� %���ڷ� ���ȴ�.
 * %d:10����(����), %f:�Ǽ�, %s:���� %n(or)\n:����, %t(or)\t:��, %% : %
 * ��ȯ���ڸ� ������ ���ڴ� �ش� �ڸ��� �״�� ���.
 * ���� %f�� (#.000000)����ó�� �Ҽ���6�ڸ����� ����ϸ� %.3f ó�� ��.���ڸ� ǥ���ϸ� �Ҽ�������3�ڸ�(#.000)���� ǥ����.
*/
	
	public static void main(String[] args) throws IOException {
		Printf_Test pt = new Printf_Test();
		pt.printfTest();
		String name = "ȫ�浿";
		int a=16,b=64,c=128,d=512;
		System.out.printf("%s�� ����غô��� %d�� %d�� %d�� %d�� ��� ���ϸ� %d�̴�.%n",name,a,b,c,d,a+b+c+d);
		double weight =75.5,height=177.6;
		System.out.printf("%s�� �����Դ� %.2fkg, Ű�� %.2fcm�̴�.%n",name,weight,height);
	}
	
	public void printfTest() throws IOException{
		PrintWriter pw = null;
		int num=2,dis=363;
		String name="ȫ�浿",des="���ֵ�";
		try{
			pw = new PrintWriter("C:\\JAVA\\printtest.txt");
			pw.printf("�� ������ %d���� %s��Ƽ�� %dKm��ŭ �̵��Ͽ� %s�� �����. %n",num,name,dis,des);
			
		}finally{
			if(pw!=null)pw.close();
		}
		System.out.println("���ϻ����Ϸ�");
	}
}
