package loop.statement;

public class ForTest {
	public static void main(String[] args) {
/*		for (int i = 1; i <= 10; i++) {
			System.out.println(i + "�� �ȳ��ϼ���");
		}
		
		// ���� ���� �� ���� ����
		for (int j = 1, k = 10; j <= 10 || k == 0; j++, k--) {
			System.out.println(j + "�� �ȳ��ϼ���" + k);
		}
*/
		
/*		for (;;) { //���� ���� = true
			System.out.println("���� �ȳ��ϼ���");
		}
*/
		
		//2~9���� ������
		for(int i=2;i<10;i++){
			System.out.println("----"+i+"��----");
			for(int j=1;j<10;j++){
				System.out.println(i+"x"+j+"="+(i*j));	
			}
		}
	}
}