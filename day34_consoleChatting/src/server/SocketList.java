package server;

import java.util.ArrayList;
/**
 * ServerThread�� ���� list
 * list�� �̿��� broadcast ���� 
 *
 */
public class SocketList {
	static ArrayList<ServerThread> list = new ArrayList<ServerThread>();

	public static void removeList(ServerThread st){
		list.remove(st);
	}
	
	public static void addList(ServerThread st){
		list.add(st);
	}
	public static int numList(){
		return list.size();
	}
	
	public static void broadCast(String msg){ //������ �ִ� ����� ��ο��� sendMsg �޼ҵ� ����.
		for(ServerThread st:list){
			st.sendMsg(msg);
		}
	}
}