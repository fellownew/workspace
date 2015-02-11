package exception.basic;

import java.io.IOException;

public class ExceptionTest5 {
	public static void main(String[] args) {
		System.out.println("main 시작");
		new ExceptionTest5().a();
		System.out.println("main 종료");
	}

	public void a() {
		System.out.println("\ta() 시작");
		try {
			b();
		} catch (IOException e) {
			System.err.println("- IOE 처리 -");
		}
		System.out.println("\ta() 종료");
	}

	public void b() throws IOException {
		System.out.println("\t\tb() 시작");
		try {
			c();
		} catch (NullPointerException e) {
			System.err.println("- NullPE 처리 -");
		}

		System.out.println("\t\tb() 종료");
	}

	public void c() throws IOException, NullPointerException {
		System.out.println("\t\t\tc() 시작");
		if (Math.random() < 0.3f) {
			throw new IOException();// throw로 예외를 발생시킴.
		} else if (Math.random() < 0.6f) {
			throw new NullPointerException();
		}
		System.out.println("\t\t\tc() 종료");
	}
}
