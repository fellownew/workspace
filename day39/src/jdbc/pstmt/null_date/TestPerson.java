package jdbc.pstmt.null_date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Types;
import java.util.Date;

public class TestPerson {
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private String user = "scott";
	private String password = "tiger";
	
	public static void main(String[] args) throws Exception{
		TestPerson tp = new TestPerson();
//		tp.insertNullValueToPerSon();
//		tp.insertDateValueToPerson();
		tp.printPersons();
	}
	//primitive ���� ����Ǵ� �÷��� null �� �ֱ�.
	public void insertNullValueToPerSon() throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into person values(?,?,?,?)";
		
		try{
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setNull(1, Types.INTEGER);//DOUBLE, NUMERIC�� ����.
			pstmt.setString(2,null);
			//pstmt.setNull(2, Types.VARCHAR); // ���� ���� ��.
			pstmt.setNull(3, Types.DOUBLE);
			pstmt.setDate(4, null);
//			pstmt.setNull(4, Types.DATE);//TIME, TIMESTAMP�� ����.
			System.out.println(pstmt.executeUpdate());
		}finally{
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	public void insertDateValueToPerson() throws Exception{
		String sql = "insert into Person values(?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 30);
			pstmt.setString(2, "��ö��");
			pstmt.setDouble(3, 70.22);
			/*
			 * Oracle�� date�� �����Ǵ� Java DataType
			 * java.sql.Date - �� �� �� - setDate(index, Date)
			 * java.sql.Time - �� �� �� - setTime(index, time)
			 * java.sql.TimeStamp - �� �� �� �� �� �� - setTimeStemp(index,TimeStamp)
			 * 
			 * java.util.Date ���� ?�� �������� ��ȯ�Ͽ� �־����.	
			 */
			
			Date d = new Date();
//			java.sql.Date birthday = new java.sql.Date(d.getTime());
//			Timestamp birthday = new Timestamp(d.getTime());
			Time birthday = new Time(d.getTime());
//			pstmt.setDate(4, birthday);
//			pstmt.setTimestamp(4, birthday);
			pstmt.setTime(4, birthday);
			System.out.println(pstmt.executeUpdate());
			
		}finally{
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	public void printPersons() throws Exception{
		String sql = "select no, name, weight, birthday from person";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try{
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()){
				int no = rset.getInt(1);
				String name = rset.getString(2);
				double weigth = rset.getDouble(3);
				java.util.Date bd1 = rset.getDate(4);
				java.util.Date bd2 = rset.getTime(4);
				java.util.Date bd3 = rset.getTimestamp(4);
				System.out.println(no+"\t"+name+"\t"+weigth+"\t"+bd1+"\t"+bd2+"\t"+bd3);
			}
			
		}finally{
			if(rset!=null)rset.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		
		
	}
}
