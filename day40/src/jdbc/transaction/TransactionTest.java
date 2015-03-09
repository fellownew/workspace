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
		
		String sql1 = "insert into department values(11,'A�μ�','����')";
		String sql2 = "insert into department values(12,'B�μ�','����')";
//		if(��������){   //�̷��͵� ����.
//			conn.rollback();
//		}else{
			String sql3 = "insert into department values(13,'C�μ�','����')";
//		}
		String sql4 = "insert into department values(14,'C�μ�','����')";
		
		
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
			//transaction ���� �� ���·� data �����ؾ���.
			//transaction roll-back
			conn.rollback();
			throw e;//�ѹ� ó�� �� ȣ���� ������ �ٽ� ����.
		}finally{
			if(conn!=null)conn.close();
			if(stmt!=null)stmt.close();
		}
	}
}
