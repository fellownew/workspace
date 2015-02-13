package io.filterstream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//DataInputStream, DataOutputStream�� �̿��� primitive ������ �����.
//Filter Stream ��� - �̹� ����Ȱ� ���.
public class DataStreamTest {
	private String filePath = "C:\\JAVA\\primitive.dat";

	public static void main(String[] args) {
		DataStreamTest dst = new DataStreamTest();
		try {
			dst.writeData();
			dst.readData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeData() throws IOException {
		FileOutputStream fos = null; 
		DataOutputStream dos = null; // filter
		try {
			fos = new FileOutputStream(filePath); // node�� ����.
			dos = new DataOutputStream(fos); // filter �߰� fos�� DOS ����� �߰���.
			dos.writeDouble(1234823987592873.3);
			dos.writeLong(2038492394934893842L);
			dos.writeInt(32);
		} finally {
			if(dos!= null)dos.close();//Filter��Ʈ���� ����� ��� filter�� close() �Ѵ�. (Node�� �˾Ƽ� ������.)
		}
	}
	public void readData() throws IOException{
		//FileInputStream�� node, finally���� ���� ���� �ʿ䰡 ������ 1ȸ�� ����ϹǷ� try �ȿ� �ص� ��.
		DataInputStream dis = null;
		try{
			dis = new DataInputStream(new FileInputStream(filePath));
			double d = dis.readDouble();
			long l = dis.readLong();
			int i = dis.readInt();

			System.out.println(d+" "+i+" "+l);
		}finally{
			if(dis!=null)dis.close();
		}
	}
}