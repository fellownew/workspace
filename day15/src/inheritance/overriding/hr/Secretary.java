package inheritance.overriding.hr;

public class Secretary extends Employee{
	private String superior;
	
	public Secretary(){};
	public Secretary(int employeeId,String employeeName,int salary,String superior){
		super(employeeId,employeeName,salary);
		this.superior = superior;
	}
	@Override
	public String toString() {
		return "��    ����"+ super.toString()+", ��� = "+superior;
	}
	
}
