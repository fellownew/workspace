package day14.inheritance.hr;

public class TestEmployee {
	public static void main(String[] args) {
		Manager m1 = new Manager();
		m1.setEmployeeId(1);
		m1.setEmployeeName("ȫ�浿");
		m1.setDepartmentName("��ȹ��");
		m1.setSalary(2000000);
		m1.info();
		
		Employee e1 = new Employee(2, "��ö��", 10000000);
		System.out.println(e1.toString());
	}
}
