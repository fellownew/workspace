package day14.inheritance.hr;

public class Manager extends Employee {
	private String DepartmentName;
	public Manager(){}
	public Manager(int employeeId,String employeeName,int salary,String department){
		setEmployeeId(employeeId);
		setEmployeeName(employeeName);
		setSalary(salary);
	}
	public String getDepartmentName() {
		return DepartmentName;
	}

	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}

	@Override
	public String toString() {
		return super.toString() + ", ºÎ¼­=" + DepartmentName;
	}

	public void info() {
		System.out.println(toString());
	}
}
