package exception.userdefined;

public class ExceptionTest7 {
	public static void main(String[] args) {
		ExceptionTest7 et = new ExceptionTest7();
		//주문
		try {
			et.orderProduct(30);
		} catch (NotEnoughStockException e) {
			System.err.println(e.getMessage() + "현재 재고는" + e.getStockAmount()+ "개 입니다.");
		}
		System.out.println("========================================");
		
		//회원가입
		try {
			et.joinMember("abcd", "1345634", "홍길동");
		} catch (RejectJoinException e) {
			System.err.println(e.getMessage() );
		}
	}

	// 주문처리, 매개변수-주문량
	public void orderProduct(int orderAmount) throws NotEnoughStockException {
		int stockAmount = 20; // 재고량
		if (orderAmount > stockAmount) {
			NotEnoughStockException ne = new NotEnoughStockException("주문량이 재고량을 초과하였습니다.");
			ne.setStockAmount(stockAmount);
			throw ne;
		}
		// 주문처리
		System.out.println(orderAmount + "개 만큼 주문처리 되었습니다.");
	}

	public void joinMember(String id, String password, String name) throws RejectJoinException{
		// id는 필수 등록 사항이며 반드시 6글자 이상이어야한다.
		if (id.length() < 6) {
			RejectJoinException re = new RejectJoinException("ID는 6글자 이상으로 등록해 주세요");
			throw re;
		}
		// 가입 처리
		System.out.println("회원가입되었습니다.");
	}
}
