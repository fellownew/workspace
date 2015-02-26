package thread.sync;

//1씩 증가하는 연속된 정수를 생산하는 클래스
public class MakeSequenceNumber {
	private int num;
	
	public int getNextNumber(){
		synchronized (this) {//this 객체의 lock flag(열쇠)를 가진 Thread만 실행 할 수 있는 블럭.
			num+=1;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return num;
		}//Thread가 동기화 블럭을 빠져나오면 lockflag(열쇠)를 (this)에 반납 함.
	}
}