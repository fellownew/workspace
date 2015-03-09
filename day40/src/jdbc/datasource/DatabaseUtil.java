package jdbc.datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;

/*
 * BasicDataSource�� ����
 * BasicDataSource�� Instance ������ ������ �����鼭 Connection�� ����.
 * Connection, Statment, ResultSet�� close �ϴ� �޼ҵ� ����.
 */

public class DatabaseUtil {
	private static DatabaseUtil inst = new DatabaseUtil();
	private BasicDataSource dataSource = new BasicDataSource();

	private DatabaseUtil() {
		//dataSource ��ü ����, ���� �۾�.
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