package jdbc.basic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
/**
* Connection ����� DriverManager.getConnection(�ּ�, ������, �н�����);
* Statement ����� connection.createStatement();
* ������ ����� statement.executeQuery(��ɹ�);
* select ����� ResultSet Ÿ�� ������ ���� �� ����.
*/
public class JDBCTest {
	public static void main(String[] args) {
		//employee ���̺��� ��� row�� ��ȸ�ؼ� ����ϴ� ���α׷��� �ۼ�
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "scott";
		String password = "tiger";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		DecimalFormat df = new DecimalFormat("000");
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
			System.out.println("DB ���� �Ϸ�");
			stmt = conn.createStatement();
			String sqlStr = "select *from employee order by employee_id";
			rset = stmt.executeQuery(sqlStr);
			for(int i = 1;i<rset.getMetaData().getColumnCount();i++){
				System.out.print(rset.getMetaData().getColumnName(i)+"   ");
			}
			
			System.out.println("");

			while(rset.next()){
				int e_id = rset.getInt(1); //ù��° �÷�
				String e_name = rset.getString(2); // �ι�° �÷�
				String email = rset.getString(3); //����° �÷�
				String position = rset.getString(4);
				long salary = rset.getLong(5);
				Date date = rset.getDate(6);
				String d_id = rset.getString(7);
				System.out.println(df.format(e_id)+"\t"+e_name+" "+email+"\t"+position+"\t"+salary+"\t"+date+"\t"+d_id);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rset!=null){
				try {
					rset.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt!=null){
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
