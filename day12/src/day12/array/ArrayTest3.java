package day12.array;

public class ArrayTest3 {
	//args - command line argument : ����� ����ڷκ��� ���� ���� ���ڿ��� ������ ������ JVM�� ������.
	public static void main(String[] args) {
		System.out.println("args length : "+args.length );
		for(String s:args){
			System.out.println(s);
			
			ArrayTest3 at = new ArrayTest3();
			at.testVarArgs("asasdf");
		}
	}
	//�����μ�(VarArgs) : DataType... ������ - ȣ���ϴ� ������ ���� ���������� ������ ������ ��� ���. ���������δ� �迭 ó��
	//			�����μ� ���� �ڿ��� �Ű����� ����Ұ�.
	public void testVarArgs(String... strs){
		System.out.println("���޵� ���� �μ� ��");
		for(String s:strs){
			System.out.println(s);
		}
		
	}
	
}
