package finaltest;

//final 변수는 한번 값이 들어가면 값을 바꿀 수 없는 변수
public class FinalVariableTest {
	
	//Instance 변수에 final이 붙으면 반드시 선언시 초기화하거나 생성자에서 값을 대입해야함. (둘 중 하나)
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
