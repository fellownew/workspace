package kr.or.kosta.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kosta.vo.Customer;

/*
 * ∞Ì∞¥µÓ∑œ insertCustomer
∞Ì∞¥¡∂»∏ 	selectCustomer()
∞Ì∞¥¡∂»∏byID 	selectCustomerById(String id)
∞Ì∞¥¡∂»∏byname  	selectCustomerByName(String name)
∞Ì∞¥¡∂»∏bymileageRange 	selectCustomerBetweenMileage(int min,int max)
∞Ì∞¥∞ªΩ≈ 	updateCustomer
∞Ì∞¥ªË¡¶byID 	deleteCustomerById(int id)
 */
public class CustomerDAO {
	private static CustomerDAO dao = new CustomerDAO();
	private DataBaseUtil dbUtil= DataBaseUtil.getInstance();
	private Connection conn;
	private PreparedStatement pstmt;
	private CustomerDAO(){}
	
	public static CustomerDAO getInstance(){
		return dao;
	}
	//
	public int insertCustomer(Customer customer) throws SQLException{
		String sql = "insert into customer values (?,?,?,?,?,?)";
		int count;
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, customer.getId());
			pstmt.setString(2, customer.getPassword());
			pstmt.setString(3, customer.getName());
			pstmt.setString(4, customer.getPhoneNumber());
			pstmt.setString(5, customer.getEmail());
			pstmt.setInt(6, customer.getMileage());
			count = pstmt.executeUpdate();
		}finally {
			dbUtil.close(conn, pstmt, null);
		}
		return count;
	}
	
	public ArrayList<Customer> selectCustomer() throws SQLException{
		ArrayList<Customer> custList = new ArrayList<Customer>();
		ResultSet rset = null;
		String sql = "select *from customer";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()){
				custList.add(new Customer(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getInt(6)));
			}
		}finally{
			dbUtil.close(conn, pstmt,rset);
		}
		return custList;
	}
	
	public Customer selectCustomerById(String id) throws SQLException{
		ResultSet rset = null;
		String sql = "select *from customer where customer_id=?";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
		}finally{
			dbUtil.close(conn, pstmt,rset);
		}
		return new Customer(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getInt(6));
	}
	
	public ArrayList<Customer> selectCustomerByName(String name) throws SQLException{
		ArrayList<Customer> custList = new ArrayList<Customer>();
		ResultSet rset = null;
		String sql = "select *from customer where customer_name=?";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rset = pstmt.executeQuery();
			while(rset.next()){
				custList.add(new Customer(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getInt(6)));
			}
		}finally{
			dbUtil.close(conn, pstmt,rset);
		}
		return custList;
	}
	
	public ArrayList<Customer> selectCustomerBetweenMileage(int minMileage,int maxMileage) throws SQLException{
		ArrayList<Customer> custList = new ArrayList<Customer>();
		ResultSet rset = null;
		String sql = "select *from customer where customer_mileage between ? and ?";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, minMileage);
			pstmt.setInt(2, maxMileage);
			rset = pstmt.executeQuery();
			while(rset.next()){
				custList.add(new Customer(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getInt(6)));
			}
		}finally{
			dbUtil.close(conn, pstmt,rset);
		}
		return custList;
	}
	
	public int updateCustomer(Customer customer) throws SQLException{
		int count=0;
		String sql = "update customer set customer_id =?, customer_pwd=?, customer_name=?,customer_pnumber=?, customer_email=?, customer_mileage=? where customer_id=?";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, customer.getId());
			pstmt.setString(2, customer.getPassword());
			pstmt.setString(3, customer.getName());
			pstmt.setString(4, customer.getPhoneNumber());
			pstmt.setString(5, customer.getEmail());
			pstmt.setInt(6, customer.getMileage());
			pstmt.setString(7, customer.getId());
			count = pstmt.executeUpdate();
		}finally{
			dbUtil.close(conn, pstmt);
		}
		return count;
	}
	
	public int deleteCustomerById(String id) throws SQLException{
		int count;
		String sql = "delete from customer where customer_id=?";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			count = pstmt.executeUpdate();
		}finally{
			dbUtil.close(conn, pstmt);
		}
		return count;
	}
	
}//Class End
