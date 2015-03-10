package baseball.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Rank {
	private static ArrayList<User> userList = new ArrayList<User>();
	
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
	public static void loadRank(){
		String str=null;
		try {
			File file = new File("C:\\JAVA\\rank.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			while(br!=null){
				Object o = br.readLine();
				userList.add((User)o);
			}
			if(br!=null)br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}