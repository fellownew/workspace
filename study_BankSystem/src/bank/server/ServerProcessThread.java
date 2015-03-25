package bank.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import bank.server.managerment.AccountManagement;
import bank.server.managerment.CustomerManagement;
import bank.server.vo.Account;
import bank.server.vo.Type;

/**
 * 소켓으로부터 정보를 받아 작업을 실행하여 소켓으로 작업 결과를 뿌려줌
 * 사용자 첫 메뉴 : 1. 회원가입 2.로그인 3. 회원탈퇴
 * 로그인 이후 메뉴 : 1.통장관리 2.입금, 3.출금, 4.송금, 5.대출
 * 
 * 통장관리 메뉴 : 1.조회 2.신규 3.해지
 * 
 */
public class ServerProcessThread implements Runnable{
	private Socket socket;
	private AccountManagement accM = AccountManagement.getInstance();
	private CustomerManagement cusM = CustomerManagement.getInstance();
	private BufferedReader br = null;
	private PrintWriter pw = null;
	public ServerProcessThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {

		String str = null;
		// TODO Auto-generated method stub
		try{
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pw = new PrintWriter(socket.getOutputStream());
		pw.println("1. 회원가입 2.로그인 3. 회원탈퇴");
		str = br.readLine();
		if(str.equals("1")){//회원가입
			registerCustomer();
		}else if(str.equals("2")){//로그인
			boolean flag = login();
			while(flag){//로그인 완료 이후 작업.
				pw.println("1.통장관리 2.입금, 3.출금, 4.송금, 5.대출");
				str = br.readLine();
				if(str.equals("1")){//통장관리
						accountManage();
				}else if(str.equals("2")){//입금
					
				}else if(str.equals("3")){//출금
					
				}else if(str.equals("4")){//송금
					
				}else if(str.equals("5")){//대출
					
				}else{
					pw.println("1~5만 써주세요");
				}
			}//while end in login
		}else if(str.equals("3")){//회원 탈퇴
			withdrawCustomer();
		}else{
			//이상한 값
		}

		}catch(IOException e){
			e.getStackTrace();
		}
	}//run end
	
	public void registerCustomer() throws IOException{
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pw = new PrintWriter(socket.getOutputStream());
		pw.println("가입할 ID");
		String customerId = br.readLine();
		pw.println("비밀번호");
		String customerPassword = br.readLine();
		pw.println("이름");
		String customerName = br.readLine();
		pw.println("직업");
		String job = br.readLine();
		pw.println("나이 // 숫자만 입력 안하면 튕김");
		String temp = br.readLine();
		int age = Integer.parseInt(temp);
		pw.println("성별 : 남/여");
		temp = br.readLine();
			boolean sex=true;
		if(temp.equals("남")){
			sex=false;
		}
		pw.println("전화번호");
		String phoneNumber = br.readLine();
		pw.println("주소");
		String adress = br.readLine();
		pw.println("원하는 통장번호");
		temp = br.readLine();
		Account customerAccount = new Account(temp, 0, new Type("일반", (double) 1.0));
		int creditRating = 9;
		cusM.addCustomer(customerId, customerPassword, customerName, customerAccount, creditRating, job, age, sex, phoneNumber, adress);
	}//registerCustomer end
	
	public boolean login() throws IOException{
		boolean flag = false;
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pw = new PrintWriter(socket.getOutputStream());
		pw.println("로그인 ID");
		String customerId = br.readLine();
		pw.println("비밀번호");
		String customerPassword = br.readLine();
		//TODO 아이디 비밀번호 비교
		return flag;
	}
	public void withdrawCustomer() throws IOException{
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pw = new PrintWriter(socket.getOutputStream());
		pw.println("삭제할 ID");
		String customerId = br.readLine();
		pw.println("비밀번호");
		String customerPassword = br.readLine();
		//TODO 아이디 비밀번호 비교
		cusM.removeCustomer(customerId);//삭제
	}
	
	public void accountManage() throws IOException{
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pw = new PrintWriter(socket.getOutputStream());
		pw.println("1.조회 2.신규 3.해지");
		String str = br.readLine();
		if(str.equals("1")){//조회
			
		}else if(str.equals("2")){//신규
			
		}else if(str.equals("3")){//해지
			
		}else{
			
		}
	}
	
}//class end
