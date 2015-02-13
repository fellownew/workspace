package io.filterstream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//DataInputStream, DataOutputStream을 이용해 primitive 데이터 입출력.
//Filter Stream 사용 - 이미 연결된것 사용.
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
			fos = new FileOutputStream(filePath); // node로 연결.
			dos = new DataOutputStream(fos); // filter 추가 fos에 DOS 기능을 추가함.
			dos.writeDouble(1234823987592873.3);
			dos.writeLong(2038492394934893842L);
			dos.writeInt(32);
		} finally {
			if(dos!= null)dos.close();//Filter스트림을 사용할 경우 filter만 close() 한다. (Node는 알아서 닫힌다.)
		}
	}
	public void readData() throws IOException{
		//FileInputStream은 node, finally에서 추후 닫을 필요가 없으며 1회만 사용하므로 try 안에 해도 됨.
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