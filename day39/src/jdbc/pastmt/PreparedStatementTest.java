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
		String location = "��õ";
		String sql = "insert into department values(?,?,?)";
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		try{
			//class �θ���
			Class.forName(driverClass);
			//db ����
			conn = DriverManager.getConnection(url, user, password);
			//���� ���� - sql�� �ٷ� ����.
			pstmt = conn.prepareStatement(sql);
			//SQL ���� ?�� �ִ� ���, ������ ġȯ.
			pstmt.setInt(1, 440); // ?�� ������ 1����.
			pstmt.setString(2, "����ó");
			pstmt.setString(3,"�λ�");
			pstmt.executeUpdate();//sql�� ���� ����.

		}finally{
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
	}
}
