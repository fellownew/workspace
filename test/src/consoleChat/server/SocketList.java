package consoleChat.server;

import java.io.IOException;
import java.util.ArrayList;
/**
 * ServerThread를 모을 list
 * list를 이용해 broadcast 실행 
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
	public static void expelMember(String member) throws IOException{
		for(ServerThread st:list){
			if(st.getNickName().equals(member)){
				st.expel();
			}
		}
	}
	public static void broadCast(String msg){ //접속해 있는 사람들 모두에게 sendMsg 메소드 실행.
		for(ServerThread st:list){
			st.sendMsg(msg);
		}
	}
}