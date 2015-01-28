package day15.inheritance.overriding.hr;

public class Employee {
	private int employeeId;
	private String employeeName;
	private int salary;

	public Employee(){}
	
	public Employee(int employeeId, String employeeName, int salary) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
	}

	int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "[사원 번호 = " + employeeId + ", 사원명 = "+ employeeName + ", 봉급 = " + salary + "]";
	}

}
