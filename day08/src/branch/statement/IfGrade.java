package branch.statement;

public class IfGrade {
	static int jumsu = (int) (Math.random() * 101);

	public static void main(String[] args) {
		if (jumsu >= 90) {
			result("A");
		} else if (jumsu >= 80) {
			result("B");
		} else if (jumsu >= 70) {
			result("C");
		} else if (jumsu >= 60) {
			result("D");
		} else {
			result("E");
		}
	}

	public static void result(String str) {
		System.out.println("점수 : " + jumsu + "\n성적 : " + str);
	}
}
