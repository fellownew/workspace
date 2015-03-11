package stockmarket.server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import stockmarket.vo.Company;
import stockmarket.vo.Investor;
import stockmarket.vo.Stock;

//"1.기업현황, 2.내 현황, 3.매수, 4.매도, 5.종료"
/**
 * client 
 * 기업현황 조회 : checkCompany
 * 
 * administrator 기업 추가 : addCompany 
 * 투자자 추가 : addInvestor
 * 
 * Thread 파산 : bankruptCompany 
 * 가격변경 이벤트 : changeStock
 */
public class Data implements Serializable {
	private static Data data = new Data();
	private ArrayList<Stock> stockList;
	private ArrayList<Company> companyList;
	private ArrayList<Investor> investorList;

	private Data() {
	}

	public static Data getInstance() {
		return data;
	}

	public void checkCompany() {
		for (Company com : companyList) {
			System.out.println(com);
		}
	}

	public void addCompany(Company company) {
		companyList.add(company);
	}

	public void addInvestor(Investor investor) {
		investorList.add(investor);
	}

	public void bankruptCompany(Company company) {
		companyList.remove(company);
	}

	public void changeStock() {
		Random random = new Random();
		for (Stock stock : stockList) {
			boolean inORde = random.nextBoolean();
			int changePrice = inORde ? (random.nextInt(10) + 1) * 10 : (random.nextInt(10) + 1) * -10;
			stock.setPrice(stock.getPrice() + changePrice);
			if(changePrice<=0){
				bankruptCompany(company);
			}
		}
	}
}
