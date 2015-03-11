package stockmarket.server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import stockmarket.vo.Company;
import stockmarket.vo.Investor;
import stockmarket.vo.Stock;

//"1.�����Ȳ, 2.�� ��Ȳ, 3.�ż�, 4.�ŵ�, 5.����"
/**
 * client 
 * �����Ȳ ��ȸ : checkCompany
 * 
 * administrator ��� �߰� : addCompany 
 * ������ �߰� : addInvestor
 * 
 * Thread �Ļ� : bankruptCompany 
 * ���ݺ��� �̺�Ʈ : changeStock
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
