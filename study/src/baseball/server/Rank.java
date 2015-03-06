package baseball.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Rank {
	static ArrayList<User> userList = new ArrayList<User>();
	
	public static void addRank(User user){
		userList.add(user);
	}
	public static void saveRank(){
		try {
			PrintWriter pw = new PrintWriter(new File("C:\\JAVA\\rank.txt"));
			for(User user : userList){
				pw.println(user);
				pw.flush();
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void loadRank(Socket socket){
		String str=null;
		try {
			File file = new File("C:\\JAVA\\rank.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
			str = br.readLine();
			while(str!=null){
				pw.println(str);
				str=br.readLine();
			}
			pw.close();
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}