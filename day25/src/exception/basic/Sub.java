package exception.basic;

import java.io.IOException;

public class Sub extends Super{
	
	
//	public void methodA() throws IOException,InterruptedException{ //super���� �����͸� ���� �� ����.
		public void methodA(){// super���� �������� �ȴ��� ���� �ִ�. 
			
	}
		
		public void methodB() throws IOException,InterruptedException,ClassCastException{
			//�θ� ������ �ͺ��� ���� Ÿ���� exception���� �ڽĵ��� �� ���� �� �ִ�.
		}
		
		public void methodC(){}//�θ� �ƹ��͵� �ȴ����� �ڽĵ� ������.

}
