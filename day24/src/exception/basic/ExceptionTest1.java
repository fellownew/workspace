package exception.basic;

public class ExceptionTest1 {
	public static void main(String[] args) {
		
		try{ //���� �߻� ���ɼ��� �ִ� ����
			System.out.println("main start");
			String str = null;
			String str2 = str.concat("abc");
			System.out.println(str2);
		}catch(NullPointerException e){//�߻��� ���ܿ� ���� ó�� ����
			System.err.println(e+" �߻�");
			
		}
		System.out.println("main ����");	
	}
}
