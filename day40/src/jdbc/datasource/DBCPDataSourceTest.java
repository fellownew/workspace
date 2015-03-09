package jdbc.datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
/*DataSource(Interface) - Apache DBCP api�� BasicDataSource
* ������ Connection ������ �ִ� ��, ��ü �ȿ� ���� ������ �̸� �־��. getConnectrion()
* ConnectionPool�� ���������� ������.
*/

public class DBCPDataSourceTest {
	public static void main(String[] args) throws Exception{
/*		//BasicDataSource ��ü ����
		BasicDataSource dataSource = new BasicDataSource();
		//JDBC ���� ������ dataSource ��ü���� ���ش�. : �ʼ�!
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:XE");
		dataSource.setUsername("Scott");
		dataSource.setPassword("tiger");
		
		//ConnectionPool ���� ���� : �ɼ�. �������� ������ �⺻���� �����.
		dataSource.setInitialSize(3);// ���� ������ ConnectionPool ũ��. �⺻:0
		dataSource.setMaxTotal(10);// �ִ�� ������ Connection ��. �⺻ : 8, ����:������
		dataSource.setMaxWaitMillis(1000);// Connection��ü �ݳ��� ��ٸ� �ִ� �ð�(�и���). �⺻ : ������ ,����:������
		//������ �ð����� Ŀ�ؼ��� �ݳ��� �ȵǸ� ���� �߻�.
		dataSource.setMaxIdle(3);//�ִ� �뿩������ Connection�� ��ü ��. �⺻ : 8, ���� : ������.
		dataSource.setMinIdle(3);//���� �뿩������ Connection�� ��ü ��. �⺻ : 0, ���� : ������
*/		
		DatabaseUtil dbUtil = DatabaseUtil.getInstance();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		try{
			conn = dbUtil.getConnection();
			stmt = conn.createStatement();
			rset = stmt.executeQuery("select *from department");
			while(rset.next()){
				System.out.println(rset.getInt(1)+","+rset.getString(2)+","+rset.getString(3));
			}
		}finally{
			dbUtil.close(conn, stmt, rset);
		}
	}
}
