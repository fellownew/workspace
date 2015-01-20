package branch.statement;

public class SwitchCaseTest {
	public static void main(String[] args) {
		//int형 case
		int x = 10;
		switch (x) {
		case 10:
			System.out.println("x=10");
			break;
		case 20:
			System.out.println("x=20");
			break;
		case 30:
			System.out.println("x=30");
			break;
		default:
			System.out.println("x=?");
		}
		//char형 case
		char c = 'A';
		switch (c) {
		case 'A':
			System.out.println("c='A'");
			break;
		case 'B':
			System.out.println("c='B'");
			break;
		case 'C':
			System.out.println("c='C'");
			break;
		default:
			System.out.println("c=?");
		}
		//String형 case
		String city = "서울";
		switch (city) {
		case "서울":
			System.out.println("특별시");
			break;
		case "인천":
		case "부산":
		case "울산":
		case "대전":
		case "대구":
		case "광주":
			System.out.println("광역시");
			break;
		default:
			System.out.println("알수 없음");
		}
		//날짜 가져오기
		int d1 = 4;
		int d2 = 6;
		GetDateSwitch gd = new GetDateSwitch();
		GetDateSwitch gd2 = new GetDateSwitch();
		System.out.println(d1+"월의 날짜 수는 "+gd.getDate(d1)+"일 입니다");
		System.out.println(d2+"월의 날짜 수는 "+gd2.getDateIf(d2)+"일 입니다");

	}

	
}
