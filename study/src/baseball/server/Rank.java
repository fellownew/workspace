package baseball.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}