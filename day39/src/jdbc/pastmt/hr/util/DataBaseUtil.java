package jdbc.pastmt.hr.util;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;
public class DataBaseUtil {
	private static DataBaseUtil inst = new DataBaseUtil();
	private BasicDataSource dataSource;
	
	private DataBaseUtil(){
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:XE");
		dataSource.setUsername("scott");
		dataSource.setPassword("tiger");
		
		dataSource.setInitialSize(2);
		dataSource.setMaxTotal(10);
		
	}
	
	public static DataBaseUtil getInstance(){
		return inst;
	}
	
	public Connection getConnection() throws Exception{
		return dataSource.getConnection();
	}
	
	public void close(ResultSet rset,Statement stmt, Connection conn) throws Exception{
		if(rset!=null){
			rset.close();
		}
		if(stmt!=null){
			stmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
}
