package charsequence.test;

public class StringBufferTest_template {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("good morning");
		sb.setLength(5);//sb�� ���ڼ� 5�� ����
		System.out.println(sb.length()); //sb���� ���
		System.out.println(sb); //stringbuffer�� toString�� �������̵� �Ǿ�����.
		
		sb.setCharAt(2,'c'); //sb 2�ε��� ���ڸ� c�� ����
		System.out.println(sb); 
		
		System.out.println(sb.append("hi"));//sb�� hi �߰�
		System.out.println(sb.insert(1,"lee"));//1�� �ε������� lee�� ����(����� ����)
		
		System.out.println(sb.length());
		System.out.println(sb.capacity());	//�� ������ ũ�� ��ȸ
		
		sb.setCharAt(1,'u');//1�� �ε��� u�� ����
		sb.append("kim");//kim �߰�
		System.out.println(sb);
		StringBuffer sb1 = new StringBuffer("0123456789");
		sb1.delete(2, 5);//2~4�ε��� ����
		System.out.println(sb1);
		sb1.replace(0, 2, "���Ͽ�");//0~2�ε��� ���Ͽ��� ��ü(0~1�� ����� "���Ͽ�"�� ����)
		System.out.println(sb1);
		System.out.println(sb1.length()+" - "+sb1.capacity());
		sb1.trimToSize();//���� ũ�⸦ ������� ũ��� ������
		System.out.println(sb1.length()+" - "+sb1.capacity());
		//stringbuffer���� equal()�� �������̵� �Ǿ����� ����. equal�� ���ϸ� �ȵ�.
		StringBuffer sb3 = new StringBuffer("abc");
		StringBuffer sb4 = new StringBuffer("abc");
		System.out.println(sb3.equals(sb4));
	}
}
