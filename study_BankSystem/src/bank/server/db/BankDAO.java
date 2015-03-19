package bank.server.db;


public class BankDAO {
	private static BankDAO dao = new BankDAO();
	private DataBaseUtil dbUtil= DataBaseUtil.getInstance();
	private BankDAO(){}
	
	private static BankDAO getInstance(){
		return dao;
	}
	
}
