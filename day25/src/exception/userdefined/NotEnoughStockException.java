package exception.userdefined;

public class NotEnoughStockException extends Exception {
	private int stockAmount;

	public NotEnoughStockException() {
	}

	public NotEnoughStockException(String message) {
		super(message);
	}// exception 객체. getMessage()를 통해 조회할 수 있는 문자열값, -> 예외처리하는 곳으로 보낼 메세지 설정.

	public int getStockAmount() {
		return stockAmount;
	}

	public void setStockAmount(int stockAmount) {
		this.stockAmount = stockAmount;
	}
}
