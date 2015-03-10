package stockmarket.server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import stockmarket.vo.Company;
import stockmarket.vo.Investor;
import stockmarket.vo.Stock;

public class Data implements Serializable{
	private static ArrayList<Stock> stockList;
	private static ArrayList<Company> companyList;
	private static ArrayList<Investor> investorList;
	
	public static void addCompany(Company company){
		companyList.add(company);
	}
	public static void addInvestor(Investor investor){
		investorList.add(investor);
	}
	
	public static void bankruptCompany(Company company){
		companyList.remove(company);
	}
	
	public static void changeStock(){
		Random random = new Random();
		for(Stock stock : stockList){
		boolean inORde = random.nextBoolean();
		int changePrice = inORde?(random.nextInt(10)+1)*10:(random.nextInt(10)+1)*-10;
		stock.setPrice(stock.getPrice()+changePrice);
		}
	}
}
