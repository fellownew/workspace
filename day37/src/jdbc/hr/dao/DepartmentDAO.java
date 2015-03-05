package jdbc.hr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jdbc.hr.vo.Department;
/*
 * Department 테이블과 관련된 DB 작업을 처리할 클래스.
 */
public class DepartmentDAO {//Data Access Object
private String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
private String user = "scott";
private String password = "tiger";
	//insert된 레코드 수 리턴.
	
	public int insertDepartment(Department department) throws SQLException{
		//department  테이블에 하나의 row를 insert 함.
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
	 * ID를 매개변수로 받아 부서 정보를 삭제
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
		//notnull 컬럼이 아닌 경우  
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
	 * 조회할 부서의 id를 받아 Department로 리턴.
	 * Primary key로 조회하는 것임.
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
			//쿼리 실행
			rset = stmt.executeQuery(sql);
			//조회결과 처리
			if(rset.next()){//조회된 row가 있다면
				department = new Department(rset.getInt(1),rset.getString(2),rset.getString(3));
			}
		}finally{
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}
		return department;
	}
	/**
	 * 조회 가능 개수 0~n개 ArrayList로 리턴.
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
			//쿼리 실행
			rset = stmt.executeQuery(sql);
			//조회결과 처리
			while(rset.next()){//조회된 row가 있다면
				departmentList.add(new Department(rset.getInt(1),rset.getString(2),rset.getString(3)));
			}
		}finally{
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}
		return departmentList;
	}
	/**
	 * 조회 결과 개수 0~n개 ArrayList로 리턴.
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
			//쿼리 실행
			rset = stmt.executeQuery(sql);
			//조회결과 처리
			while(rset.next()){//조회된 row가 있다면
				departmentList.add(new Department(rset.getInt(1),rset.getString(2),rset.getString(3)));
			}
		}finally{
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}
		return departmentList;
	}
}