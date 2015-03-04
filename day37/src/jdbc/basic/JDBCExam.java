package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * driver �ҷ�����.
 * Connection ����� DriverManager.getConnection(�ּ�, ������, �н�����);
 * Statement ����� connection.createStatement();
 * ������ ����� statement.executeQuery(��ɹ�);
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
			Class.forName(driverClass);//JDBC4.0, jdk1.6 ���� �ڵ����� driver�� �������.
			//���� forName�� ������ Ŭ���� ��ü�� ����°������� 
			conn = DriverManager.getConnection(url, user, password); //�ش� ������ DB�� ���� �� Connection ����
			System.out.println("�����ͺ��̽��� ���� ����");
			stmt = conn.createStatement(); // 
			String selectSQL = "select department_id,department_name,location from department order by department_id";
			
			rset = stmt.executeQuery(selectSQL); // ������ ���� ���� �� ResultSet���� ��� ����
			
			while(rset.next()){//���� row�� ��������, row�� ������ ture, ������ false ����
				String d_id = rset.getString(1); //ù��° �÷�
				String d_name = rset.getString(2); // �ι�° �÷�
				String loc = rset.getString(3); //����° �÷�
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
