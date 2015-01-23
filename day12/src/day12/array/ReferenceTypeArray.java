package day12.array;

import day12.array.vo.Student;

public class ReferenceTypeArray {
	public static void main(String[] args) {
			ReferenceTypeArray rta = new ReferenceTypeArray();
			rta.arrayBasic2();
	}
	
	public void arrayBasic() {
		// Reference Type 배열 생성,
		// Student 객체 모아서 관리할 배열 선언
		Student stu[];
		stu = new Student[4];

		stu[0]=new Student();
		stu[1]=new Student("ID1","김학생",20);
		stu[2]=new Student("ID2","이학생",21);
		stu[3]=new Student("ID3","박학생",19);
		stu[0].setAge(31);
		stu[0].setId("ID0");
		stu[0].setName("알고보니 교수님");
		for(int i=0;i<stu.length;i++){
			System.out.println(stu[i].toString());
		}		
	}
	public void arrayBasic2(){
		Student s = new Student();
		Student [] stu = {new Student(),new Student("ID4","최학생",17),s};
		for(Student i : stu){
			System.out.println(i.getAge());
		}
	}
}