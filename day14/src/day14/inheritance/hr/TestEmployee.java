package day14.inheritance.hr;

public class TestEmployee {
	public static void main(String[] args) {
		Manager m1 = new Manager();
		m1.setEmployeeId(1);
		m1.setEmployeeName("È«±æµ¿");
		m1.setDepartmentName("±âÈ¹ºÎ");
		m1.setSalary(2000000);
		m1.info();
		
		Employee e1 = new Employee(2, "±èÃ¶¼ö", 10000000);
		System.out.println(e1.toString());
	}
}
