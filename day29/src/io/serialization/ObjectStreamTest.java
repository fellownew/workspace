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
		Student stu = new Student("id-1","ȫ�浿",1,2);
		School sch = new School("K���б�","��⵵ ������ �д籸");
		stu.setSchool(sch);
		
		ObjectStreamTest ot = new ObjectStreamTest();
		ot.writeObject(stu);
		
		Object obj = ot.readObject();
		Student sss = (Student) obj;
		System.out.println(sss);
	}

	public void writeObject(Object obj) throws IOException {
		// �Ű����� obj�� ���� ��ü�� sutdent.obj ���Ϸ� ��� ó��
		// ��ü ��� Stream : ObjectOutputStream(FilterStream)���.

		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(obj);
		} finally {
			if (oos != null)
				oos.close();
		}
		System.out.println("��¿Ϸ�");
	}
	public Object readObject() throws ClassNotFoundException, IOException{
		//student.obj�� �����(����ȭ��) ��ü�� �о return ó��
		//��ü �Է� Stream : ObjectInputStream(FilterStream)���
		ObjectInputStream ois = null;
		Object obj = null;
		try{
			ois = new ObjectInputStream(new FileInputStream(file));
			obj = ois.readObject();//������ȭ, read�� ��ü�� Ŭ���� ������ ���ٸ� ClassNotFoundException�� �߻���Ŵ.
		}finally{
			if(ois!=null)ois.close();
		}
		return obj;
	}
}