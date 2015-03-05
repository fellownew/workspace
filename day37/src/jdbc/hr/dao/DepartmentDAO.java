package jdbc.hr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jdbc.hr.vo.Department;
/*
 * Department ���̺�� ���õ� DB �۾��� ó���� Ŭ����.
 */
public class DepartmentDAO {//Data Access Object
private String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
private String user = "scott";
private String password = "tiger";
	//insert�� ���ڵ� �� ����.
	
	public int insertDepartment(Department department) throws SQLException{
		//department  ���̺� �ϳ��� row�� insert ��.
		String sql = "insert into department values("+department.getDepartmentId()+",'"+department.getDepartmentName()+"','"+department.getLocation()+"')";
		Connection conn = null;
		Statement stmt = null;
		int count = 0;
			try{
				conn = DriverManager.getConnection(url,user,password);
				stmt = conn.createStatement();
				count = stmt.executeUpdate(sql);
			}finally{
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			}
		return count;
	}
	/**
	 * ID�� �Ű������� �޾� �μ� ������ ����
	 * @param departmentId
	 * @return int count
	 * @throws SQLException
	 */
	public int deleteDepartmentByID(int departmentId) throws SQLException{
		String sql = "delete from department where department_id="+departmentId;
		Connection conn = null;
		Statement stmt = null;
		int count=0;
		try{
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			count = stmt.executeUpdate(sql);
		}finally{
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}
		return count;
	}
	
	public int deleteDepartmentByLocation(String location) throws SQLException{
		String sql = "delete from department ";
		if(location ==null){
			sql = sql+"where location is null";			
		}else{
			sql = sql+"where location='"+location+"'";
		}
		//notnull �÷��� �ƴ� ���  
		Connection conn = null;
		Statement stmt = null;
		int count=0;
		try{
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			count = stmt.executeUpdate(sql);
		}finally{
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}
		return count;
	}
	
	public int updateDepartmentByID(Department dept) throws Exception{
		Connection conn = null;
		Statement stmt = null;
		int count =0;
		String sql = "update department set department_name='"+dept.getDepartmentName()+
				"',location='"+dept.getLocation()+"' where department_id="+dept.getDepartmentId();
		try{
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			count = stmt.executeUpdate(sql);
		}finally{
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}
		return count;
	}
	
	/**
	 * ��ȸ�� �μ��� id�� �޾� Department�� ����.
	 * Primary key�� ��ȸ�ϴ� ����.
	 * @param departmentId
	 * @return
	 * @throws SQLException
	 */
	public Department selectDepartmentById(int departmentId) throws SQLException{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset= null;
		Department department = null;
		String sql = "select department_id, department_name, location from department where department_id='"+departmentId+"'";
		try{
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			//���� ����
			rset = stmt.executeQuery(sql);
			//��ȸ��� ó��
			if(rset.next()){//��ȸ�� row�� �ִٸ�
				department = new Department(rset.getInt(1),rset.getString(2),rset.getString(3));
			}
		}finally{
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}
		return department;
	}
	/**
	 * ��ȸ ���� ���� 0~n�� ArrayList�� ����.
	 * @param departmentId
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Department> selectDepartmentList() throws SQLException{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset= null;
		ArrayList<Department> departmentList = new ArrayList<Department>();
		String sql = "select *from department";
		try{
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			//���� ����
			rset = stmt.executeQuery(sql);
			//��ȸ��� ó��
			while(rset.next()){//��ȸ�� row�� �ִٸ�
				departmentList.add(new Department(rset.getInt(1),rset.getString(2),rset.getString(3)));
			}
		}finally{
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}
		return departmentList;
	}
	/**
	 * ��ȸ ��� ���� 0~n�� ArrayList�� ����.
	 * @param location
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Department> selectDepartmentListByLocation(String location) throws SQLException{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset= null;
		ArrayList<Department> departmentList = new ArrayList<Department>();
		String sql = "select department_id, department_name, location from department where location ";
		if(location==null){
			 sql = sql+"is null";
		}else{
			 sql = sql + "='"+location+"'";
		}
		try{
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			//���� ����
			rset = stmt.executeQuery(sql);
			//��ȸ��� ó��
			while(rset.next()){//��ȸ�� row�� �ִٸ�
				departmentList.add(new Department(rset.getInt(1),rset.getString(2),rset.getString(3)));
			}
		}finally{
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}
		return departmentList;
	}
}