package branch.statement;

public class GetDateSwitch {
	// 1,3,5,7,8,10,12 -> 31일
	// 4,6,9,11, -> 30일
	// 2월 28일
	public int getDate(int month) {
		int day = 0;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			day = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			day = 30;
			break;
		case 2:
			day = 28;
			break;
		default:
			day = 0;
		}
		return day;
	}

	public int getDateIf(int month) {
		int day = 0;
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
				|| month == 10 || month == 12) {
			day = 31;
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			day = 30;
		} else if (month == 2) {
			day = 28;
		} else {
			day = 0;
		}
		return day;
	}
}
