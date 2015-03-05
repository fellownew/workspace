package jdbc.hr.main;

import jdbc.hr.dao.DepartmentDAO;
import jdbc.hr.vo.Department;

public class DepartmentTest {
	public static void main(String[] args) throws Exception{
		int cnt=0;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		DepartmentDAO dao = new DepartmentDAO();
		
//		cnt = dao.insertDepartment(new Department(201,"해외협력부","서울"));
//		cnt = dao.deleteDepartmentByID(201);
//		cnt = dao.updateDepartmentByID(new Department(101,"해외협력부","서울"));
		System.out.println(dao.selectDepartmentById(200));
		System.out.println(dao.selectDepartmentById(25));
//		System.out.println(cnt+".");
		System.out.println("-select all-");
		for(Department d:dao.selectDepartmentList()){
			System.out.println(d);
		}
		System.out.println("-select by location-");
		for(Department d:dao.selectDepartmentListByLocation("서울")){
			System.out.println(d);
		}
	}
}