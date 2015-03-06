package jdbc.pastmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementTest {
	public static void main(String[] args) throws Exception {
		String driverClass = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "scott";
		String password = "tiger";
		String location = "인천";
		String sql = "insert into department values(?,?,?)";
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		try{
			//class 부르기
			Class.forName(driverClass);
			//db 연결
			conn = DriverManager.getConnection(url, user, password);
			//상태 생성 - sql을 바로 지정.
			pstmt = conn.prepareStatement(sql);
			//SQL 문의 ?가 있는 경우, 값으로 치환.
			pstmt.setInt(1, 440); // ?의 순서는 1부터.
			pstmt.setString(2, "지원처");
			pstmt.setString(3,"부산");
			pstmt.executeUpdate();//sql문 넣지 않음.

		}finally{
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
	}
}
