package baseball.server;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseballDAO {
	private static BaseballDAO dao = new BaseballDAO();
	private DataBaseUtil dbUtil= DataBaseUtil.getInstance();
	private Connection conn;
	private PreparedStatement pstmt;
	
	private BaseballDAO(){}
	
	public static BaseballDAO getInstance(){
		return dao;
	}
	
	public int insertRank(User user) throws SQLException{
		String sql = "insert into rank values(?,?,?)";
		int count;
			try{
				conn = dbUtil.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,user.getCount());
				pstmt.setString(2, user.getName());
				pstmt.setDate(3, new Date(user.getDate().getTime()));
				count = pstmt.executeUpdate();
			}finally{
				dbUtil.close(conn, pstmt, null);
			}
		return count;
	}
}
