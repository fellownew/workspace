package io.serialization;

import io.serialization.vo.School;
import io.serialization.vo.Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {
	private File file = new File("C:\\JAVA", "Student.obj");

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Student stu = new Student("id-1","홍길동",1,2);
		School sch = new School("K중학교","경기도 성남시 분당구");
		stu.setSchool(sch);
		
		ObjectStreamTest ot = new ObjectStreamTest();
		ot.writeObject(stu);
		
		Object obj = ot.readObject();
		Student sss = (Student) obj;
		System.out.println(sss);
	}

	public void writeObject(Object obj) throws IOException {
		// 매개변수 obj로 받은 객체를 sutdent.obj 파일로 출력 처리
		// 객체 출력 Stream : ObjectOutputStream(FilterStream)사용.

		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(obj);
		} finally {
			if (oos != null)
				oos.close();
		}
		System.out.println("출력완료");
	}
	public Object readObject() throws ClassNotFoundException, IOException{
		//student.obj에 저장된(직렬화된) 객체를 읽어서 return 처리
		//객체 입력 Stream : ObjectInputStream(FilterStream)사용
		ObjectInputStream ois = null;
		Object obj = null;
		try{
			ois = new ObjectInputStream(new FileInputStream(file));
			obj = ois.readObject();//역직렬화, read한 객체의 클래스 파일이 없다면 ClassNotFoundException을 발생시킴.
		}finally{
			if(ois!=null)ois.close();
		}
		return obj;
	}
}