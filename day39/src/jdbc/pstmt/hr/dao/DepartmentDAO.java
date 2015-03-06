package jdbc.pstmt.hr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.pstmt.hr.vo.Department;

public class DepartmentDAO {
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private String user = "scott";
	private String password = "tiger";

	public int insertDepartment(Department dept) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into department values (?,?,?)";
		int count;
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getDepartmentId());
			pstmt.setString(2, dept.getDepartmentName());
			pstmt.setString(3, dept.getLocation());
			count = pstmt.executeUpdate();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return count;
	}

	public int updateDepartment(Department dept) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update department set department_name=?, location=? where department_id=?";
		int count;
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(3, dept.getDepartmentId());
			pstmt.setString(1, dept.getDepartmentName());
			pstmt.setString(2, dept.getLocation());
			count = pstmt.executeUpdate();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return count;
	}

	public int deleteDepartmentByID(int departmentId) throws SQLException {
		String sql = "delete from department where department_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, departmentId);
			count = pstmt.executeUpdate();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return count;
	}

	public int deleteDepartmentByLocation(String location) throws SQLException {
		String sql = "delete from department where location=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, location);
			count = pstmt.executeUpdate();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return count;
	}

	public ArrayList<Department> selectDepartment() throws SQLException {
		ArrayList<Department> deptList = new ArrayList<Department>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select *from department";
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			// 쿼리 실행
			rset = pstmt.executeQuery();
			// 조회결과 처리
			while (rset.next()) {// 조회된 row가 있다면
				deptList.add(new Department(rset.getInt(1), rset.getString(2),
						rset.getString(3)));
			}
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return deptList;
	}

	public Department selectDepartmentById(int departmentId)
			throws SQLException {
		Department dept = new Department();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select *from department where departmend_id=?";
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, departmentId);
			// 쿼리 실행
			rset = pstmt.executeQuery();
			// 조회결과 처리
			if (rset.next()) {// 조회된 row가 있다면
				dept = new Department(rset.getInt(1), rset.getString(2),
						rset.getString(3));
			}
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return dept;
	}

	public ArrayList<Department> selectDepartmentByLocation(String location)
			throws SQLException {
		ArrayList<Department> deptList = new ArrayList<Department>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select department_id, department_name, location from department where ";
		if (location == null) {
			sql = sql + "location is null";
		} else {
			sql = sql + "location = ?";
		}
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, location);
			// 쿼리 실행
			rset = pstmt.executeQuery();
			// 조회결과 처리
			while (rset.next()) {// 조회된 row가 있다면
				deptList.add(new Department(rset.getInt(1), rset.getString(2),
						rset.getString(3)));
			}
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return deptList;
	}

	public ArrayList<Department> selectDepartmentByLocation2(String location)
			throws SQLException {
		ArrayList<Department> deptList = new ArrayList<Department>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select department_id, department_name, location from department where ";
		if (location == null) {
			sql = sql + "location is null";
		} else {
			sql = sql + "location like '%'||?||'%'";
		}
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, location);
			// 쿼리 실행
			rset = pstmt.executeQuery();
			// 조회결과 처리
			while (rset.next()) {// 조회된 row가 있다면
				deptList.add(new Department(rset.getInt(1), rset.getString(2),rset.getString(3)));
			}
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return deptList;
	}
}
