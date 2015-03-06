package jdbc.pstmt.hr.main;

import jdbc.pstmt.hr.dao.DepartmentDAO;
import jdbc.pstmt.hr.vo.Department;

public class TestDepartment {
	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		DepartmentDAO dao = new DepartmentDAO();
//		dao.insertDepartment(new Department(160,"운영2부","강원"));
//		dao.updateDepartment(new Department(160,"운영3부","강원"));
//		
//		for(Department d:dao.selectDepartment()){
//			System.out.println(d);
//		}
		
		for(Department d:dao.selectDepartmentByLocation2("서")){
			System.out.println(d);
		}
	}
}
