package network.fileio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleFileServer {
	//파일을 읽어서 클라이언트에게 보내줌.
	//FileInputStream ( C:\\JAVA\\lighthouse.jpg )
	//Output : Client 
	public static void main(String[] args) {
		//서버단 연결과정
		// 1. ServerSocket 생성
		// 클라이언트가 연결하면 Socket을 생성해주는 공장.
		ServerSocket serverSocket = null;
		Socket socket = null;
		OutputStream os = null; //클라이언트에게 보내주기위한 output
		FileInputStream fis = null; //내 컴퓨터에 있는 파일을 읽기위한 input
		try {
			serverSocket = new ServerSocket(5000);
		} catch (IOException e) {
			// 5000번 포트가 사용중일경우 충돌로 인해 예외 발생.
			e.printStackTrace();
			return;
		}

		// 2. 클라이언트의 요청 대기
		while(true){
			try {
				System.out.println("-----Client의 접속을 기다립니다.-----");
				socket = serverSocket.accept(); // 클라이언트 연결을 기다리다 연결되면 socket을 리턴.
				System.out.println("-----Client가 접속했습니다.-----");
				// 3. Socket으로부터 In/OutputStream 조회
				os = socket.getOutputStream();
				fis = new FileInputStream("C:\\JAVA\\Lighthouse.jpg");
				// 4. I/O 작업
				byte[] buffer = new byte[10000];
				int length = fis.read(buffer); //컴퓨터에 있는 파일을 읽음.
				while(length!=-1){
					os.write(buffer,0,length);//네트워크로 보냄
					length = fis.read(buffer);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				//fis 닫기
				if (fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				//os 닫기
				if (os != null) {
					try {
						os.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				//socket닫기
				if (socket != null) {
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}//while
	}//main end
}//class end
