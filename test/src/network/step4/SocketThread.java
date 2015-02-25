package network.step4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketThread extends Thread{
	ServerSocket serverSocket = null;
	Socket socket = null;
	
	public SocketThread(int portNo) throws IOException{
		serverSocket = new ServerSocket(portNo);
		while(true){
		socket=serverSocket.accept();
		System.out.println("Á¢¼Ó");
		}
	}
		
	
}
