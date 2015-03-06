package jdbc.pstmt.hr.main;

import jdbc.pstmt.hr.dao.DepartmentDAO;
import jdbc.pstmt.hr.vo.Department;

public class TestDepartment {
	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		DepartmentDAO dao = new DepartmentDAO();
//		dao.insertDepartment(new Department(160,"�2��","����"));
//		dao.updateDepartment(new Department(160,"�3��","����"));
//		
//		for(Department d:dao.selectDepartment()){
//			System.out.println(d);
//		}
		
		for(Department d:dao.selectDepartmentByLocation2("��")){
			System.out.println(d);
		}
	}
}
