package finaltest;

//final ������ �ѹ� ���� ���� ���� �ٲ� �� ���� ����
public class FinalVariableTest {
	
	//Instance ������ final�� ������ �ݵ�� ����� �ʱ�ȭ�ϰų� �����ڿ��� ���� �����ؾ���. (�� �� �ϳ�)
	//final String INSTANCE_FINAL_VAR1;
	final String INSTANCE_FINAL_VAR1="abc";
	final long INSTANCE_FINAL_VAR2;
	final double INSTANCE_FINAL_VAR3=2352.34;
	
	public FinalVariableTest(long var){
		INSTANCE_FINAL_VAR2 = var;
	}
	
//	public FinalVariableTest(double var){
//		INSTANCE_FINAL_VAR3 = var;
//	}
	
	
	public void test(){
		final int LOCAL_FINAL_VAR1 = 1000;
		//LOCAL_FINAL_VAR1 = 23;
		final char LOCAL_FINAL_VAR2;
		LOCAL_FINAL_VAR2 ='A';
		//LOCAL_FINAL_VAR2 ='C';
		System.out.println(LOCAL_FINAL_VAR1+LOCAL_FINAL_VAR2);
	}
}
