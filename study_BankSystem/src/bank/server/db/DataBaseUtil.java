package bank.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;

public class DataBaseUtil {
	private static DataBaseUtil inst = new DataBaseUtil();
	private BasicDataSource dataSource = new BasicDataSource();
	private DataBaseUtil(){
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:XE");
		dataSource.setUsername("scott");
		dataSource.setPassword("tiger");
	}
	
	public static DataBaseUtil getInstance() {
		return inst;
	}
	
	public Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	public void close(Connection conn,Statement stmt,ResultSet rset)throws SQLException{
		if(rset!=null)rset.close();
		if(stmt!=null)stmt.close();
		if(conn!=null)conn.close();
	}
	public void close(Connection conn,Statement stmt)throws SQLException{
		if(stmt!=null)stmt.close();
		if(conn!=null)conn.close();
	}
}
