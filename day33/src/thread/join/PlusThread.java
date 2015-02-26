package thread.join;

public class PlusThread implements Runnable {
	private int start, end, sum;

	public PlusThread(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getSum() {

		return sum;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = start; i <= end; i++) {
			sum += i;
		}
	}
}
