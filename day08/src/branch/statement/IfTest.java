package branch.statement;

public class IfTest {
	public static void main(String[] args) {
		int x = 100;
		/*
		 * ���ǹ� if 
		 * if(����){ �����ڵ�
		 * }else{�����ڵ�
		 * }
		 */

		if (x < 0) {
			System.out.println("����");
		} else if (x == 0) {
			System.out.println("0");
		} else {
			System.out.println("���");
		}
		String city ="����"; // String���� ����񱳴� ==�� ����ġ �ʴ�.
		if(city.equals("����")){
			System.out.println("�ѱ��� ����");
		}else if(city.equals("����¡")){
			System.out.println("�߱��� ����");
		}else if(city.equals("����")){
			System.out.println("�Ϻ��� ����");
		}
		
		
	}
}
