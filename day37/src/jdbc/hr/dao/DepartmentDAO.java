package jdbc.hr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.hr.vo.Department;
/*
 * Department 테이블과 관련된 DB 작업을 처리할 클래스.
 */
public class DepartmentDAO {//Data Access Object
	Connection conn = null;
	Statement stmt = null;
	ResultSet rset = null;
	
	public int insertDepartment(Department department	) throws SQLException{
		//department  테이블에 하나의 row를 insert 함.
		
		rset = stmt.executeQuery("insert into department (department_id,department_name,location) values ("+department.getDepartmentId()+","+department.getDepartmentName()+","+department.getLocation()+")");
		return rset.getMetaData().getColumnCount();
	}
	
	public int deleteDepartmentByID(int departmentId) throws SQLException{
		rset = stmt.executeQuery("delete from department where department_id='"+departmentId+"'");
		return rset.getMetaData().getColumnCount();
	}
	
	public void selectDepartment() throws SQLException{
		rset = stmt.executeQuery("select *from department");
	}
	
	public void updateDepartment(){
		
	}
	
}
