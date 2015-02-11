package exception.userdefined;

public class ExceptionTest7 {
	public static void main(String[] args) {
		ExceptionTest7 et = new ExceptionTest7();
		//�ֹ�
		try {
			et.orderProduct(30);
		} catch (NotEnoughStockException e) {
			System.err.println(e.getMessage() + "���� ����" + e.getStockAmount()+ "�� �Դϴ�.");
		}
		System.out.println("========================================");
		
		//ȸ������
		try {
			et.joinMember("abcd", "1345634", "ȫ�浿");
		} catch (RejectJoinException e) {
			System.err.println(e.getMessage() );
		}
	}

	// �ֹ�ó��, �Ű�����-�ֹ���
	public void orderProduct(int orderAmount) throws NotEnoughStockException {
		int stockAmount = 20; // ���
		if (orderAmount > stockAmount) {
			NotEnoughStockException ne = new NotEnoughStockException("�ֹ����� ����� �ʰ��Ͽ����ϴ�.");
			ne.setStockAmount(stockAmount);
			throw ne;
		}
		// �ֹ�ó��
		System.out.println(orderAmount + "�� ��ŭ �ֹ�ó�� �Ǿ����ϴ�.");
	}

	public void joinMember(String id, String password, String name) throws RejectJoinException{
		// id�� �ʼ� ��� �����̸� �ݵ�� 6���� �̻��̾���Ѵ�.
		if (id.length() < 6) {
			RejectJoinException re = new RejectJoinException("ID�� 6���� �̻����� ����� �ּ���");
			throw re;
		}
		// ���� ó��
		System.out.println("ȸ�����ԵǾ����ϴ�.");
	}
}
