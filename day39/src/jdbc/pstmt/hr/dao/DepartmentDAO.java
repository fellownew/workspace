package jdbc.pstmt.hr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.pastmt.hr.util.DataBaseUtil;
import jdbc.pstmt.hr.vo.Department;
/*
 * Singleton 적용.
 * BasicDataSource를 이용하여 Connection 생성
 * 패키지 jdbc.pstmt.hr.uil
 * 클래스 DatabaseUtil(싱글톤, getConnection(), clsoe()메소드등
 */
public class DepartmentDAO {
	private static DepartmentDAO dao = new DepartmentDAO();
	private DataBaseUtil dbUtil = DataBaseUtil.getInstance();

	
	private DepartmentDAO(){}
	public static DepartmentDAO getInstance(){
		return dao;
	}

	public int insertDepartment(Department dept) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into department values (?,?,?)";
		int count;
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getDepartmentId());
			pstmt.setString(2, dept.getDepartmentName());
			pstmt.setString(3, dept.getLocation());
			count = pstmt.executeUpdate();
		} finally {
			dbUtil.close(null, pstmt, conn);
		}
		return count;
	}

	public int updateDepartment(Department dept) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update department set department_name=?, location=? where department_id=?";
		int count;
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(3, dept.getDepartmentId());
			pstmt.setString(1, dept.getDepartmentName());
			pstmt.setString(2, dept.getLocation());
			count = pstmt.executeUpdate();
		} finally {
			dbUtil.close(null, pstmt, conn);
		}
		return count;
	}

	public int deleteDepartmentByID(int departmentId) throws Exception {
		String sql = "delete from department where department_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, departmentId);
			count = pstmt.executeUpdate();
		} finally {
			dbUtil.close(null, pstmt, conn);
		}
		return count;
	}

	public int deleteDepartmentByLocation(String location) throws Exception {
		String sql = "delete from department where location=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, location);
			count = pstmt.executeUpdate();
		} finally {
			dbUtil.close(null, pstmt, conn);
		}
		return count;
	}

	public ArrayList<Department> selectDepartment() throws Exception {
		ArrayList<Department> deptList = new ArrayList<Department>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select *from department";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			// 쿼리 실행
			rset = pstmt.executeQuery();
			// 조회결과 처리
			while (rset.next()) {// 조회된 row가 있다면
				deptList.add(new Department(rset.getInt(1), rset.getString(2),
						rset.getString(3)));
			}
		} finally {
			dbUtil.close(null, pstmt, conn);
		}
		return deptList;
	}

	public Department selectDepartmentById(int departmentId)
			throws Exception {
		Department dept = new Department();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select *from department where departmend_id=?";
		try {
			conn = dbUtil.getConnection();
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
			dbUtil.close(null, pstmt, conn);
		}
		return dept;
	}

	public ArrayList<Department> selectDepartmentByLocation(String location)
			throws Exception {
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
			conn = dbUtil.getConnection();
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
			dbUtil.close(null, pstmt, conn);
		}
		return deptList;
	}

	public ArrayList<Department> selectDepartmentByLocation2(String location)
			throws Exception {
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
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, location);
			// 쿼리 실행
			rset = pstmt.executeQuery();
			// 조회결과 처리
			while (rset.next()) {// 조회된 row가 있다면
				deptList.add(new Department(rset.getInt(1), rset.getString(2),rset.getString(3)));
			}
		} finally {
			dbUtil.close(null, pstmt, conn);
		}
		return deptList;
	}
}
