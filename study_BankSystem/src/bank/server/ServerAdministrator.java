package bank.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 皋牢 皋家靛 焊蜡
 * 包府磊 皋春 角青
 * 包府磊 皋春 : 1.篮青包府, 2.绊按包府.
 * 篮青包府 皋春 : 1. Type-捞磊啦 包府.
 * 绊按包府 皋春 : 1.炼雀, 2.绊按积己
 */
public class ServerAdministrator {
	public static void main(String[] args) {
		new Thread(new ServerSocketThread()).start();
		BufferedReader key = null;
		boolean flag = true;
		key = new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.println("包府磊 牢刘");
			String confirm = key.readLine();
			while(confirm.equals("admin")){
				System.out.println("1. 篮青包府, 2.绊按包府");
				String str = key.readLine();
				if(str.equals("1")){
					System.out.println("1.惑前包府, 2.捞磊啦 包府");
					str = key.readLine();
					if(str.equals("1")){
						//TODO Type 包府						
					}else if(str.equals("2")){
						//TODO 捞磊啦 函版
					}
					
				}else if(str.equals("2")){
					System.out.println("1.炼雀, 2.绊按积己");
					str = key.readLine();
					if(str.equals("1")){
						//TODO 绊按包府-炼雀 皋家靛 何福扁
					}else if(str.equals("2")){
						//TODO 绊按包府-绊按积己 皋家靛 何福扁
					}
				}
			}//while end	
		}catch(Exception e){
			e.getStackTrace();
		}
	}//main end
}//class end
