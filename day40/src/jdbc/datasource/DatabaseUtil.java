package jdbc.datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;

/*
 * BasicDataSource를 관리
 * BasicDataSource를 Instance 변수로 가지고 있으면서 Connection을 제공.
 * Connection, Statment, ResultSet을 close 하는 메소드 제공.
 */

public class DatabaseUtil {
	private static DatabaseUtil inst = new DatabaseUtil();
	private BasicDataSource dataSource = new BasicDataSource();

	private DatabaseUtil() {
		//dataSource 객체 생성, 설정 작업.
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:XE");
		dataSource.setUsername("scott");
		dataSource.setPassword("tiger");
		
		dataSource.setInitialSize(2);
		dataSource.setMaxTotal(10);
	}

	public static DatabaseUtil getInstance() {
		return inst;
	}
	public Connection getConnection() throws Exception{
		return dataSource.getConnection();
	}
	
	public void close(Connection conn,Statement stmt,ResultSet rset)throws Exception{
		if(rset!=null)rset.close();
		if(stmt!=null)stmt.close();
		if(conn!=null)conn.close();
	}
}