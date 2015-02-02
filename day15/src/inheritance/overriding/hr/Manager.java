package inheritance.overriding.hr;

public class Manager extends Employee {
	private String DepartmentName;
	public Manager(){}
	public Manager(int employeeId,String employeeName,int salary,String department){
		super(employeeId,employeeName,salary); //구현부의 첫 명령어로 사용해야함.
		//super()와 this()는 동시에 사용할 수 없으며, 둘 중 하나가 없다면 super()가 자동으로 생성(컴파일러가)됨
		this.DepartmentName = department;
	}
	public String getDepartmentName() {
		return DepartmentName;
	}

	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}

	@Override
	public String toString() {
		return "매니저 정보"+super.toString() + ", 부서 = " + DepartmentName;
	}

	public void info() {
		System.out.println(toString());
	}
}
