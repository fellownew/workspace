package exception.basic;

public class FinallyTest {
	public static void main(String[] args) {
//		finallyTest1();
		finallyTest2(3);
	}
	
	public static void finallyTest1(){
		int[] arr = {1,2,3,4,5};
		for(int i = 0;i<=arr.length;i++){
			try{
			System.out.println("�迭��"+i+"�� �� : "+arr[i]);
			if(i==2){int k = 10/0;}
			}catch(ArrayIndexOutOfBoundsException e){
				System.err.println("���� �߻�");
			}finally{
				System.out.println("\tfinally �� - ������ ����");
			}
		}
		System.out.println("finallyTest1() ����");
	}
	public static void finallyTest2(int var){
		System.out.println("finallyTest2() ����");
		try{
			if(var==1){
				System.out.println("���������� ����Ǵ� ����");
			}else if(var==2){
				System.out.println(10/0);//���� �߻� ����
			}else if(var==3){
				System.exit(0); // ���α׷��� �����Ű�� �޼ҵ�. -> �̷���� finally�� ������ �ȵ�.
//				return;//����
			}
		}finally{
			System.out.println("finally ��");
		}
		System.out.println("finallyTest2() ����");
	}
}
