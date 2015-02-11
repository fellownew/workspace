package exception.userdefined;

public class NotEnoughStockException extends Exception {
	private int stockAmount;

	public NotEnoughStockException() {
	}

	public NotEnoughStockException(String message) {
		super(message);
	}// exception ��ü. getMessage()�� ���� ��ȸ�� �� �ִ� ���ڿ���, -> ����ó���ϴ� ������ ���� �޼��� ����.

	public int getStockAmount() {
		return stockAmount;
	}

	public void setStockAmount(int stockAmount) {
		this.stockAmount = stockAmount;
	}
}
