package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * driver 불러오기.
 * Connection 만들기 DriverManager.getConnection(주소, 유저명, 패스워드);
 * Statement 만들기 connection.createStatement();
 * 쿼리문 만들기 statement.executeQuery(명령문);
 */
public class JDBCExam {
	public static void main(String[] args) {
		String driverClass = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "scott";
		String password = "tiger";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			Class.forName(driverClass);//JDBC4.0, jdk1.6 부터 자동으로 driver를 등록해줌.
			//원래 forName의 역할은 클래스 객체를 만드는것이지만 
			conn = DriverManager.getConnection(url, user, password); //해당 정보로 DB에 접속 후 Connection 리턴
			System.out.println("데이터베이스에 연결 성공");
			stmt = conn.createStatement(); // 
			String selectSQL = "select department_id,department_name,location from department order by department_id";
			
			rset = stmt.executeQuery(selectSQL); // 쿼리문 전송 실행 후 ResultSet으로 결과 리턴
			
			while(rset.next()){//다음 row를 가져오며, row가 있으면 ture, 없으면 false 리턴
				String d_id = rset.getString(1); //첫번째 컬럼
				String d_name = rset.getString(2); // 두번째 컬럼
				String loc = rset.getString(3); //세번째 컬럼
				System.out.println(d_id+"\t"+d_name+"\t"+loc);
			}
			
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}finally{
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
			}//finally end
		}//main method end
	}//Class end
