package inheritance.overriding.hr;

public class Manager extends Employee {
	private String DepartmentName;
	public Manager(){}
	public Manager(int employeeId,String employeeName,int salary,String department){
		super(employeeId,employeeName,salary); //�������� ù ��ɾ�� ����ؾ���.
		//super()�� this()�� ���ÿ� ����� �� ������, �� �� �ϳ��� ���ٸ� super()�� �ڵ����� ����(�����Ϸ���)��
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
		return "�Ŵ��� ����"+super.toString() + ", �μ� = " + DepartmentName;
	}

	public void info() {
		System.out.println(toString());
	}
}
