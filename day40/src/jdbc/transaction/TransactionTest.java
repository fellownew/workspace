package jdbc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TransactionTest {
	public static void main(String[] args) throws Exception{
//		Class.forName("oracle.jdbc.driver.Oracledriver");
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "scott";
		String password = "tiger";
		Connection conn= null;
		Statement stmt = null;
		
		String sql1 = "insert into department values(11,'A부서','서울')";
		String sql2 = "insert into department values(12,'B부서','서울')";
//		if(오류조건){   //이런것도 가능.
//			conn.rollback();
//		}else{
			String sql3 = "insert into department values(13,'C부서','서울')";
//		}
		String sql4 = "insert into department values(14,'C부서','서울')";
		
		
		try{
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql2);
			stmt.executeUpdate(sql3);	
			conn.commit();
			conn.setAutoCommit(true);
		}catch(Exception e){
			e.getStackTrace();
			//transaction 시작 전 상태로 data 복구해야함.
			//transaction roll-back
			conn.rollback();
			throw e;//롤백 처리 후 호출한 곳으로 다시 던짐.
		}finally{
			if(conn!=null)conn.close();
			if(stmt!=null)stmt.close();
		}
	}
}
