package day12.array;

import day12.array.vo.Student;

public class ReferenceTypeArray {
	public static void main(String[] args) {
			ReferenceTypeArray rta = new ReferenceTypeArray();
			rta.arrayBasic2();
	}
	
	public void arrayBasic() {
		// Reference Type �迭 ����,
		// Student ��ü ��Ƽ� ������ �迭 ����
		Student stu[];
		stu = new Student[4];

		stu[0]=new Student();
		stu[1]=new Student("ID1","���л�",20);
		stu[2]=new Student("ID2","���л�",21);
		stu[3]=new Student("ID3","���л�",19);
		stu[0].setAge(31);
		stu[0].setId("ID0");
		stu[0].setName("�˰��� ������");
		for(int i=0;i<stu.length;i++){
			System.out.println(stu[i].toString());
		}		
	}
	public void arrayBasic2(){
		Student s = new Student();
		Student [] stu = {new Student(),new Student("ID4","���л�",17),s};
		for(Student i : stu){
			System.out.println(i.getAge());
		}
	}
}