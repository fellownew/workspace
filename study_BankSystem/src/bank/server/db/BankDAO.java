package bank.server.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class BankDAO {
	private static BankDAO dao = new BankDAO();
	private DataBaseUtil dbUtil= DataBaseUtil.getInstance();
	private BankDAO(){}
	
	private static BankDAO getInstance(){
		return dao;
	}
	
	//Account
	public void insertAccount(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="insert "; //TODO
		
		try{
		conn = dbUtil.getConnection();
		pstmt = conn.prepareStatement(sql);
		//TODO set
		pstmt.executeQuery();
		}catch(SQLException e){
			
		}
	}
	//Bank
	
	//Custormer
	
	//Type
	
	
	
}
