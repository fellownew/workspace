package jdbc.basic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
/**
* Connection 만들기 DriverManager.getConnection(주소, 유저명, 패스워드);
* Statement 만들기 connection.createStatement();
* 쿼리문 만들기 statement.executeQuery(명령문);
* select 실행시 ResultSet 타입 변수에 넣을 수 있음.
*/
public class JDBCTest {
	public static void main(String[] args) {
		//employee 테이블의 모든 row를 조회해서 출력하는 프로그램을 작성
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
			System.out.println("DB 연결 완료");
			stmt = conn.createStatement();
			String sqlStr = "select *from employee order by employee_id";
			rset = stmt.executeQuery(sqlStr);
			for(int i = 1;i<rset.getMetaData().getColumnCount();i++){
				System.out.print(rset.getMetaData().getColumnName(i)+"   ");
			}
			
			System.out.println("");

			while(rset.next()){
				int e_id = rset.getInt(1); //첫번째 컬럼
				String e_name = rset.getString(2); // 두번째 컬럼
				String email = rset.getString(3); //세번째 컬럼
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
