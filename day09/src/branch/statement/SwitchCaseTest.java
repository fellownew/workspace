package branch.statement;

public class SwitchCaseTest {
	public static void main(String[] args) {
		//int�� case
		int x = 10;
		switch (x) {
		case 10:
			System.out.println("x=10");
			break;
		case 20:
			System.out.println("x=20");
			break;
		case 30:
			System.out.println("x=30");
			break;
		default:
			System.out.println("x=?");
		}
		//char�� case
		char c = 'A';
		switch (c) {
		case 'A':
			System.out.println("c='A'");
			break;
		case 'B':
			System.out.println("c='B'");
			break;
		case 'C':
			System.out.println("c='C'");
			break;
		default:
			System.out.println("c=?");
		}
		//String�� case
		String city = "����";
		switch (city) {
		case "����":
			System.out.println("Ư����");
			break;
		case "��õ":
		case "�λ�":
		case "���":
		case "����":
		case "�뱸":
		case "����":
			System.out.println("������");
			break;
		default:
			System.out.println("�˼� ����");
		}
		//��¥ ��������
		int d1 = 4;
		int d2 = 6;
		GetDateSwitch gd = new GetDateSwitch();
		GetDateSwitch gd2 = new GetDateSwitch();
		System.out.println(d1+"���� ��¥ ���� "+gd.getDate(d1)+"�� �Դϴ�");
		System.out.println(d2+"���� ��¥ ���� "+gd2.getDateIf(d2)+"�� �Դϴ�");

	}

	
}
