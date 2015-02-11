package exception.basic;

import java.io.IOException;

public class Sub extends Super{
	
	
//	public void methodA() throws IOException,InterruptedException{ //super에서 던진것만 던질 수 있음.
		public void methodA(){// super에서 던진것을 안던질 수는 있다. 
			
	}
		
		public void methodB() throws IOException,InterruptedException,ClassCastException{
			//부모가 던지는 것보다 하위 타입의 exception들은 자식들이 다 던질 수 있다.
		}
		
		public void methodC(){}//부모가 아무것도 안던져서 자식도 못던짐.

}
