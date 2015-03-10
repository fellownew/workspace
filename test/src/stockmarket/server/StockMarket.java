package stockmarket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import stockmarket.vo.Company;
/**
 * ���� �����ڿ�, ��� ���� ����.
 * �����ڷκ��� ���� ����� ����.
 */
public class StockMarket {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		new Thread(new StockMarketServer()).start();
		System.out.println("1.�������, 2.����");
		String select;
		String str;
		String[] str2;
		try {
			select = br.readLine();
			while (!select.equals("2")) {
				if(select.equals("1")){
					System.out.println("�����ȣ/����̸�/Ÿ��");
					str = br.readLine();
					str2 = str.split("/", 3);
					Data.addCompany(new Company(str2[0], str2[1], str2[2]));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(br!=null)
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
