package statictest.card;

public class CardTest {
	public static void main(String[] args) {
		//static ����/�޼ҵ�� Ŭ������.����/�޼ҵ��  ���� ���� ��.
		System.out.println("ī�� ���� : "+Card.getHeight());
		System.out.println("ī�� �ʺ� : "+Card.getWidth());
		new Card();new Card();new Card();new Card();new Card();new Card();new Card();new Card();
		new Card(3,"�پ�");
		System.out.println("���ݱ��� ������ ī���� ���� "+Card.getCount()+"���Դϴ�.");
	}
}
