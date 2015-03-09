package jdbc.datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
/*DataSource(Interface) - Apache DBCP api의 BasicDataSource
* 역할은 Connection 생성해 주는 것, 객체 안에 연결 정보를 미리 넣어둠. getConnectrion()
* ConnectionPool을 내부적으로 제공함.
*/

public class DBCPDataSourceTest {
	public static void main(String[] args) throws Exception{
/*		//BasicDataSource 객체 생성
		BasicDataSource dataSource = new BasicDataSource();
		//JDBC 연결 설정을 dataSource 객체에게 해준다. : 필수!
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:XE");
		dataSource.setUsername("Scott");
		dataSource.setPassword("tiger");
		
		//ConnectionPool 관련 설정 : 옵션. 설정하지 않으면 기본값을 사용함.
		dataSource.setInitialSize(3);// 최초 생성할 ConnectionPool 크기. 기본:0
		dataSource.setMaxTotal(10);// 최대로 생성할 Connection 수. 기본 : 8, 음수:무제한
		dataSource.setMaxWaitMillis(1000);// Connection객체 반납을 기다릴 최대 시간(밀리초). 기본 : 무제한 ,음수:무제한
		//지정한 시간동안 커넥션이 반납이 안되면 예외 발생.
		dataSource.setMaxIdle(3);//최대 대여가능한 Connection의 객체 수. 기본 : 8, 음수 : 무제한.
		dataSource.setMinIdle(3);//최초 대여가능한 Connection의 객체 수. 기본 : 0, 음수 : 무제한
*/		
		DatabaseUtil dbUtil = DatabaseUtil.getInstance();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		try{
			conn = dbUtil.getConnection();
			stmt = conn.createStatement();
			rset = stmt.executeQuery("select *from department");
			while(rset.next()){
				System.out.println(rset.getInt(1)+","+rset.getString(2)+","+rset.getString(3));
			}
		}finally{
			dbUtil.close(conn, stmt, rset);
		}
	}
}
