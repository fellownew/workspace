package day12.array;

import day12.array.vo.Student;

public class StudentArrayTest {
	public static void main(String[] args) {
		StudentArrayTest sat = new StudentArrayTest();

		Student s1 = new Student("ID1", "���л�", 20);
		Student s2 = new Student("ID2", "���л�", 21);
		Student s3 = new Student("ID3", "���л�", 19);
		Student stuArr[] = { s1, s2, s3 };
		sat.printAllStudentInfo(stuArr);
		int avg = sat.getAgeAverage(stuArr);
		String search = sat.findStudentById(stuArr, "ID2");
		System.out.println("�л����� ��� ���̰� : " + avg);
		System.out.println(search);
	}

	public void printAllStudentInfo(Student[] stu) {

		for (int i = 0; i < stu.length; i++) {
			System.out.println(stu[i].toString());
		}
		// ���� for�� �̿��� ���.
		// System.out.println("------------------------------------------------");
		// for(Student i : stu){
		// System.out.println(i.toString());
		// }
	}

	// ��� �л� ������ ��� ����
	public int getAgeAverage(Student stu[]) {
		int sum = 0;
		for (int i = 0; i < stu.length; i++) {
			sum += stu[i].getAge();
		}
		return sum / stu.length;
	}

	// 1�� �Ű������� ���� �迭 ���� �л��� 2�� �Ű������� ���� id�� �л��� ã�Ƽ� ����.
	public String findStudentById(Student[] stu, String id) {
		String str = "�����ϴ�";
		for (int i = 0; i < stu.length; i++) {
			if (id.equals(stu[i].getId())) {
				str = stu[i].toString();
				break;
			}
		}
		return "�˻��� �л� ���� : " + str;
	}
}
