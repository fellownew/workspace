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
	ArrayList<Member> ar = null; // Member 담을 arraylist
	String basicPath = "C:\\JAVA\\member_list.obj";
	
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		MemberInput mi = new MemberInput();
		try {
			mi.manageMemberConsole();
			System.out.println("정상적으로 종료합니다.");
		} catch (Exception e) {
			System.out.println("비정상 종료");
			e.getStackTrace();
		}
	}
	public MemberInput(){
		ObjectInputStream ois = null;
		try{
		System.out.println("member_list를 불러옵니다.");
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
			// 여러 값을  받기 위한 리더
			br = new BufferedReader(new InputStreamReader(System.in)); 
			String menu = "0"; // 단순 기본값 nullpointexception 방지용
			while (menu != null) {
				System.out.println("1.등록 2.조회 3.수정 4.삭제. 5.저장 6.로드 7.종료");
				menu = br.readLine();
				if (menu.equals("1")) {// 값이 1이면 등록 메소드 실행
					registMember();
				} else if (menu.equals("2")) { // 값이 2이면 조회 메소드 실행
					findMember();
				} else if ((menu.equals("3"))) { //값이 3이면 정보 수정
					modifyMember();
				} else if ((menu.equals("4"))) {//값이 4이면 정보 삭제
					removeMember();
				} else if ((menu.equals("5"))) {//값이 5이면 저장.
					saveFile();
				}else if ((menu.equals("6"))) {// 값이 6이면 로드.
					loadFile();
				}else if ((menu.equals("7"))) {// 값이 6이면 null값으로 EOF 전달하면서 종료
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
		try { // 나이 숫자만 들어갈 수 있도록 예외처리
			System.out.println("정보를 입력해주세요");
			System.out.print("이름 : ");
			String name = regibr.readLine();
			if(name.length()<1){
				System.out.println("이름에 빈칸은 허용되지 않습니다."); //TODO exception
			}
			System.out.print("나이(숫자 입력) : ");
			int age = Integer.parseInt((regibr.readLine()));
			System.out.print("전화번호 : ");
			String telNo = regibr.readLine();
			ar.add(new Member(name, age, telNo)); // 받은 이름, 나이, 전화번호를 Member 객체로 리스트에 추가.
			System.out.println("등록이 완료되었습니다.");
		} catch (NumberFormatException e) {
			System.out.println("나이는 숫자만 입력해주세요");
		}
	}

	public void findMember() {
		if(ar.size()==0){
			System.out.println("등록된 회원이 없습니다.");
		}else{
			for (Member m : ar) {
				System.out.println(m); // 등록된 멤버 리스트 조회
			}
		}
	}
	
	public void saveFile() throws IOException{
		BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
		ObjectOutputStream oos = null;
		try{
		System.out.println("저장할 파일명을 적어주세요");
		String temp = fileName.readLine();
		String name = "C:\\JAVA\\"+temp+".txt";
		oos = new ObjectOutputStream(new FileOutputStream(name));
		oos.writeObject(ar);
		System.out.println(name+"경로에 정상적으로 저장되었습니다.");
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
		System.out.println("member_list에 저장하시겠습니까?(y/n)");
		String temp = fileName.readLine();
		while(temp.equals("y")||temp.equals("n")){
			if(temp.equals("y")){
				oos = new ObjectOutputStream(new FileOutputStream(basicPath));
				oos.writeObject(ar);
				System.out.println("정상적으로 저장되었습니다.");
			}else if(temp.equals("n")){
				System.out.println("저장하지 않고 종료합니다.");
			}else{
				System.out.println("y/n 중에 써주세요");
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
		System.out.println("수정할 정보의 이름을 입력해주세요");
		moName = modifyName.readLine();
		for(int i =0;i<ar.size();i++){
			if(ar.get(i).getName().equals(moName)){
				System.out.println(moName+"의 나이를 입력해주세요");
				int age = Integer.parseInt(modifyName.readLine());
				System.out.println("연락처를 입력해주세요");
				String telNo = modifyName.readLine();
				ar.set(i, new Member(moName,age,telNo));
			}else{
				System.out.println("찾는 이름이 없습니다.");
			}
		}
	}
	public void removeMember() throws IOException{
		BufferedReader removeName = new BufferedReader(new InputStreamReader(System.in));
		String reName= null;
		System.out.println("수정할 정보의 이름을 입력해주세요");
		reName = removeName.readLine();
		for(int i =0;i<ar.size();i++){
			if(!(ar.get(i).getName().equals(reName))){
				System.out.println("찾는 이름이 없습니다.");
			}else{
				ar.remove(i);
				System.out.println("해당 정보가 정상 삭제되었습니다.");
			}
		}
	}
	public void loadFile() throws IOException, ClassNotFoundException{
		BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
		ObjectInputStream ois = null;
		try{
		System.out.println("불러올 파일명을 적어주세요");
		String temp = fileName.readLine();
		String name = "C:\\JAVA\\"+temp+".txt";
		ois = new ObjectInputStream(new FileInputStream(name));
		ar = (ArrayList<Member>) ois.readObject();
		System.out.println(name+"경로의 파일을 정상적으로 불러왔습니다.");
		}finally{
			if(ois!=null){
				ois.close();
			}
		}
	}
	
}//클래스 끝