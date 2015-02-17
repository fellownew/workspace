package io.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class MemberInput implements Serializable{
	ArrayList<Member> ar = null; // Member ���� arraylist
	String basicPath = "C:\\JAVA\\member_list.obj";
	
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		MemberInput mi = new MemberInput();
		try {
			mi.manageMemberConsole();
			System.out.println("���������� �����մϴ�.");
		} catch (Exception e) {
			System.out.println("������ ����");
			e.getStackTrace();
		}
	}
	public MemberInput(){
		ObjectInputStream ois = null;
		try{
		System.out.println("member_list�� �ҷ��ɴϴ�.");
		ois = new ObjectInputStream(new FileInputStream(basicPath));
		ar = (ArrayList<Member>) ois.readObject();
		}catch(Exception e){
			ar = new ArrayList<Member>();
		}finally{
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void manageMemberConsole() throws IOException, ClassNotFoundException {
		BufferedReader br = null;
		ObjectOutputStream oos = null;
		try {
			// ���� ����  �ޱ� ���� ����
			br = new BufferedReader(new InputStreamReader(System.in)); 
			String menu = "0"; // �ܼ� �⺻�� nullpointexception ������
			while (menu != null) {
				System.out.println("1.��� 2.��ȸ 3.���� 4.����. 5.���� 6.�ε� 7.����");
				menu = br.readLine();
				if (menu.equals("1")) {// ���� 1�̸� ��� �޼ҵ� ����
					registMember();
				} else if (menu.equals("2")) { // ���� 2�̸� ��ȸ �޼ҵ� ����
					findMember();
				} else if ((menu.equals("3"))) { //���� 3�̸� ���� ����
					modifyMember();
				} else if ((menu.equals("4"))) {//���� 4�̸� ���� ����
					removeMember();
				} else if ((menu.equals("5"))) {//���� 5�̸� ����.
					saveFile();
				}else if ((menu.equals("6"))) {// ���� 6�̸� �ε�.
					loadFile();
				}else if ((menu.equals("7"))) {// ���� 6�̸� null������ EOF �����ϸ鼭 ����
					oos = new ObjectOutputStream(new FileOutputStream(basicPath));
					oos.writeObject(ar);
//					selectSave();
					menu = null;
				}
			}
		} finally {
			br.close();
		}
	}

	public void registMember() throws IOException {
		BufferedReader regibr = new BufferedReader(new InputStreamReader(System.in));
		try { // ���� ���ڸ� �� �� �ֵ��� ����ó��
			System.out.println("������ �Է����ּ���");
			System.out.print("�̸� : ");
			String name = regibr.readLine();
			if(name.length()<1){
				System.out.println("�̸��� ��ĭ�� ������ �ʽ��ϴ�."); //TODO exception
			}
			System.out.print("����(���� �Է�) : ");
			int age = Integer.parseInt((regibr.readLine()));
			System.out.print("��ȭ��ȣ : ");
			String telNo = regibr.readLine();
			ar.add(new Member(name, age, telNo)); // ���� �̸�, ����, ��ȭ��ȣ�� Member ��ü�� ����Ʈ�� �߰�.
			System.out.println("����� �Ϸ�Ǿ����ϴ�.");
		} catch (NumberFormatException e) {
			System.out.println("���̴� ���ڸ� �Է����ּ���");
		}
	}

	public void findMember() {
		if(ar.size()==0){
			System.out.println("��ϵ� ȸ���� �����ϴ�.");
		}else{
			for (Member m : ar) {
				System.out.println(m); // ��ϵ� ��� ����Ʈ ��ȸ
			}
		}
	}
	
	public void saveFile() throws IOException{
		BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
		ObjectOutputStream oos = null;
		try{
		System.out.println("������ ���ϸ��� �����ּ���");
		String temp = fileName.readLine();
		String name = "C:\\JAVA\\"+temp+".txt";
		oos = new ObjectOutputStream(new FileOutputStream(name));
		oos.writeObject(ar);
		System.out.println(name+"��ο� ���������� ����Ǿ����ϴ�.");
		}finally{
			if(oos!=null){
				oos.close();
			}
		}
	}
	
	public void selectSave() throws IOException{
		BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
		ObjectOutputStream oos = null;
		try{
		System.out.println("member_list�� �����Ͻðڽ��ϱ�?(y/n)");
		String temp = fileName.readLine();
		while(temp.equals("y")||temp.equals("n")){
			if(temp.equals("y")){
				oos = new ObjectOutputStream(new FileOutputStream(basicPath));
				oos.writeObject(ar);
				System.out.println("���������� ����Ǿ����ϴ�.");
			}else if(temp.equals("n")){
				System.out.println("�������� �ʰ� �����մϴ�.");
			}else{
				System.out.println("y/n �߿� ���ּ���");
				temp = fileName.readLine();
			}
		}
		}finally{
			if(oos!=null){
				oos.close();
			}
		}
	}
	
	public void modifyMember() throws IOException{
		BufferedReader modifyName = new BufferedReader(new InputStreamReader(System.in));
		String moName= null;
		System.out.println("������ ������ �̸��� �Է����ּ���");
		moName = modifyName.readLine();
		for(int i =0;i<ar.size();i++){
			if(ar.get(i).getName().equals(moName)){
				System.out.println(moName+"�� ���̸� �Է����ּ���");
				int age = Integer.parseInt(modifyName.readLine());
				System.out.println("����ó�� �Է����ּ���");
				String telNo = modifyName.readLine();
				ar.set(i, new Member(moName,age,telNo));
			}else{
				System.out.println("ã�� �̸��� �����ϴ�.");
			}
		}
	}
	public void removeMember() throws IOException{
		BufferedReader removeName = new BufferedReader(new InputStreamReader(System.in));
		String reName= null;
		System.out.println("������ ������ �̸��� �Է����ּ���");
		reName = removeName.readLine();
		for(int i =0;i<ar.size();i++){
			if(!(ar.get(i).getName().equals(reName))){
				System.out.println("ã�� �̸��� �����ϴ�.");
			}else{
				ar.remove(i);
				System.out.println("�ش� ������ ���� �����Ǿ����ϴ�.");
			}
		}
	}
	public void loadFile() throws IOException, ClassNotFoundException{
		BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
		ObjectInputStream ois = null;
		try{
		System.out.println("�ҷ��� ���ϸ��� �����ּ���");
		String temp = fileName.readLine();
		String name = "C:\\JAVA\\"+temp+".txt";
		ois = new ObjectInputStream(new FileInputStream(name));
		ar = (ArrayList<Member>) ois.readObject();
		System.out.println(name+"����� ������ ���������� �ҷ��Խ��ϴ�.");
		}finally{
			if(ois!=null){
				ois.close();
			}
		}
	}
	
}//Ŭ���� ��