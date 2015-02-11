package exception.basic;

import java.io.IOException;

public class ExceptionTest5 {
	public static void main(String[] args) {
		System.out.println("main ����");
		new ExceptionTest5().a();
		System.out.println("main ����");
	}

	public void a() {
		System.out.println("\ta() ����");
		try {
			b();
		} catch (IOException e) {
			System.err.println("- IOE ó�� -");
		}
		System.out.println("\ta() ����");
	}

	public void b() throws IOException {
		System.out.println("\t\tb() ����");
		try {
			c();
		} catch (NullPointerException e) {
			System.err.println("- NullPE ó�� -");
		}

		System.out.println("\t\tb() ����");
	}

	public void c() throws IOException, NullPointerException {
		System.out.println("\t\t\tc() ����");
		if (Math.random() < 0.3f) {
			throw new IOException();// throw�� ���ܸ� �߻���Ŵ.
		} else if (Math.random() < 0.6f) {
			throw new NullPointerException();
		}
		System.out.println("\t\t\tc() ����");
	}
}
