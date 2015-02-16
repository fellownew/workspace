package io.stn.member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MemberInput {
	ArrayList<Member> ar = new ArrayList<Member>(); // Membeer ���� arraylist

	public static void main(String[] args) {
		MemberInput mi = new MemberInput();
		try {
			mi.manageMemberConsole();
			System.out.println("���������� �����մϴ�.");
		} catch (Exception e) {
			System.out.println("������ ����");
			e.getStackTrace();
		}
	}

	public void manageMemberConsole() throws IOException {
		BufferedReader br = null;
		try {
			// ���� ����  �ޱ� ���� ����
			br = new BufferedReader(new InputStreamReader(System.in)); 
			String menu = "0"; // �ܼ� �⺻�� nullpointexception ������
			while (menu != null) {
				System.out.println("1.��� 2.��ȸ 3.���� 4.����. 5.���� 6.����");
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
				}else if ((menu.equals("6"))) {// ���� 6�̸� null������ EOF �����ϸ鼭 ����
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
			System.out.println("��ϵ� ȸ���� �����ϴ�.");//TODO Exception
		}else{
			for (Member m : ar) {
				System.out.println(m); // ��ϵ� ��� ����Ʈ ��ȸ
			}
		}
	}
	
	public void saveFile() throws IOException{
		BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter save=null;
		try{
		System.out.println("������ ���ϸ��� �����ּ���");
		String temp = fileName.readLine();
		String name = "C:\\JAVA\\"+temp+".txt";
		save = new PrintWriter(name);
		for(Member m:ar){
			save.println(m);
		}
		System.out.println(name+"��ο� ���������� ����Ǿ����ϴ�.");
		}finally{
		if(save!=null){
			save.close();
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
	
	
}//Ŭ���� ��