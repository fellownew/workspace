package charsequence.test;

public class StringBuffer_MethodChain {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer(200);
		//�޼ҵ� ü�̴� - ��ü�� ������ �����ϴ� �޼ҵ尡 ���� ó���� ����� ��ü(�ڽ�)�� �����ϵ��� �Ͽ� ���������� ������ ó���� �� �ֵ��� �޼ҵ带 �����ϴ� ���.
		// �������� ���� �������� �ʰ� �ϳ��� ���๮���� ������ ������ �� �ְ� ó���� �� �ִ�.
		sb.append("a").append("b").append("c").append("d").append(false).append(5234).append("end");
		System.out.println(sb);
	}
}
