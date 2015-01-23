package day12.array;

import day12.array.vo.Student;

public class StudentArrayTest {
	public static void main(String[] args) {
		StudentArrayTest sat = new StudentArrayTest();

		Student s1 = new Student("ID1", "김학생", 20);
		Student s2 = new Student("ID2", "이학생", 21);
		Student s3 = new Student("ID3", "박학생", 19);
		Student stuArr[] = { s1, s2, s3 };
		sat.printAllStudentInfo(stuArr);
		int avg = sat.getAgeAverage(stuArr);
		String search = sat.findStudentById(stuArr, "ID2");
		System.out.println("학생들의 평균 나이값 : " + avg);
		System.out.println(search);
	}

	public void printAllStudentInfo(Student[] stu) {

		for (int i = 0; i < stu.length; i++) {
			System.out.println(stu[i].toString());
		}
		// 향상된 for를 이용한 방법.
		// System.out.println("------------------------------------------------");
		// for(Student i : stu){
		// System.out.println(i.toString());
		// }
	}

	// 모든 학생 나이의 평균 리턴
	public int getAgeAverage(Student stu[]) {
		int sum = 0;
		for (int i = 0; i < stu.length; i++) {
			sum += stu[i].getAge();
		}
		return sum / stu.length;
	}

	// 1번 매개변수로 받은 배열 내의 학생중 2번 매개변수로 받은 id의 학생을 찾아서 리턴.
	public String findStudentById(Student[] stu, String id) {
		String str = "없습니다";
		for (int i = 0; i < stu.length; i++) {
			if (id.equals(stu[i].getId())) {
				str = stu[i].toString();
				break;
			}
		}
		return "검색한 학생 정보 : " + str;
	}
}
