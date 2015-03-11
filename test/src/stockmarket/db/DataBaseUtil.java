package stockmarket.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * 
 * @author KOSTA_03_011
 * BasicDataSource�� ����
 * BasicDataSource�� Instance ������ ������ �����鼭 Connection�� ����.
 * Connection, Statment, ResultSet�� close �ϴ� �޼ҵ� ����.
 */
public class DataBaseUtil {
	private BasicDataSource dataSource = new BasicDataSource();
	private static DataBaseUtil dbUtil = new DataBaseUtil();
	private DataBaseUtil(){
		//dataSource ��ü ����, ���� �۾�.
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:XE");
		dataSource.setUsername("scott");
		dataSource.setPassword("tiger");
		
		dataSource.setInitialSize(2);
		dataSource.setMaxTotal(10);
	}
	public static DataBaseUtil getInstance(){
		return dbUtil;
	}
	
	public Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	public void close(Connection conn,Statement stmt,ResultSet rset)throws SQLException{
		if(rset!=null)rset.close();
		if(stmt!=null)stmt.close();
		if(conn!=null)conn.close();
	}
}