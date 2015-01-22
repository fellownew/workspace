package test.security;

public class SHA2Test {
	public static void main(String[] args) {
		String testingStr = "this is test sentence.";

		System.out.println(testingStr);

		// System.out.println(SHA2Util.encrypt(testingStr, "SHA-224"));
		//
		// System.out.println(SHA2Util.encrypt(testingStr, "SHA-256"));
		//
		// System.out.println(SHA2Util.encrypt(testingStr, "SHA-384"));
		//
		// System.out.println(SHA2Util.encrypt(testingStr, "SHA-512"));
		//
		// System.out.println(SHA2Util.encrypt(testingStr));

		System.out.println(SHA2Util.calcHash(testingStr, "SHA-512"));
	}
}
