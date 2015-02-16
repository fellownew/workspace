package io.stn.member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MemberInput {
	ArrayList<Member> ar = new ArrayList<Member>(); // Membeer 담을 arraylist

	public static void main(String[] args) {
		MemberInput mi = new MemberInput();
		try {
			mi.manageMemberConsole();
			System.out.println("정상적으로 종료합니다.");
		} catch (Exception e) {
			System.out.println("비정상 종료");
			e.getStackTrace();
		}
	}

	public void manageMemberConsole() throws IOException {
		BufferedReader br = null;
		try {
			// 여러 값을  받기 위한 리더
			br = new BufferedReader(new InputStreamReader(System.in)); 
			String menu = "0"; // 단순 기본값 nullpointexception 방지용
			while (menu != null) {
				System.out.println("1.등록 2.조회 3.수정 4.삭제. 5.저장 6.종료");
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
				}else if ((menu.equals("6"))) {// 값이 6이면 null값으로 EOF 전달하면서 종료
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
			System.out.println("등록된 회원이 없습니다.");//TODO Exception
		}else{
			for (Member m : ar) {
				System.out.println(m); // 등록된 멤버 리스트 조회
			}
		}
	}
	
	public void saveFile() throws IOException{
		BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter save=null;
		try{
		System.out.println("저장할 파일명을 적어주세요");
		String temp = fileName.readLine();
		String name = "C:\\JAVA\\"+temp+".txt";
		save = new PrintWriter(name);
		for(Member m:ar){
			save.println(m);
		}
		System.out.println(name+"경로에 정상적으로 저장되었습니다.");
		}finally{
		if(save!=null){
			save.close();
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
	
	
}//클래스 끝