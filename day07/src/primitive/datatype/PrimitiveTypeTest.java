package primitive.datatype;

public class PrimitiveTypeTest {
	public static void main(String[] args) {
		// ������ : byte < short < int < long
		// int var1 = 10;
		// long var2 = 10l;
		// long var3 = 10L;
		// byte var4 = 10; // byte, short�� �������� ������ ��. ���� ǥ���ϴ� ����� ����.
		// byte var5 = 22333;
		// long var6 = 700000000000l; // ������ ���� int�� �Ѿ�� L�� �ٿ��� ��.
		int var7 = 010; // 8����
		System.out.println(var7);
		int var8 = 0x20AF; // 16����
		System.out.println(var8);
		int var9 = 3425 * 3545 * 3215 * 3245 * 235 * 344 * 398 * 393 * 359
				* 993;
		System.out.println(var9);
		long var10 = 3425l * 3545 * 3215 * 3245 * 235 * 344 * 398 * 393 * 359
				* 993;
		System.out.println(var10);

		// �Ǽ��� : float(�Ҽ�������7�ڸ�), < double(�Ҽ��� ���� 16�ڸ�) - ���е�
		// float f1 = 30.5f;
		// float f2 = 30f;
		// double d1 = 304209384.34355;
		// double d2 = 234234d;
		// �Ǽ��� ���� ��꿡 ������� �ʴ� ���� ����. -> BigDecimal Ŭ���� �̿��Ͽ� ���
		double d4 = 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1;
		System.out.println(d4);

		// ���� : cahr - �����ڵ� �� ����, ��' ' ���� ����.
		char c1 = 1010;
		char c2 = '��';
		char c3 = '\uC012';
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		// char c6 = '\'';
		char c7 = '\\';
		System.out.println(c7);
		String str1 = "Hi hello"; // �⺻Ÿ���� �ƴ� reference Ÿ��
		System.out.println(str1);
		String str2 = "a\tb\tc\td\te\t\nf";
		System.out.println(str2);
		String str3 = "c:\\temp\\source\\a.txt";
		System.out.println(str3);
		// String str4 = "�ȳ��ϼ���"+"asdlkfjalsdkf"+str2;
		// String�� ��� Ÿ���� �� ����� �����ϸ� ��� StringŸ������ �����.

		// ���� = boolean : �� : true / false
		boolean b1 = true;
		boolean b2 = false;
		System.out.println(b1 + "," + b2);

	}
}
