package charsequence.test;

public class StringBuffer_MethodChain {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer(200);
		//메소드 체이닝 - 객체의 내용을 변경하는 메소드가 변경 처리후 변경된 객체(자신)을 리턴하도록 하여 연속적으로 변경을 처리할 수 있도록 메소드를 구현하는 기법.
		// 여러번에 걸쳐 변경하지 않고 하나의 실행문으로 여러번 변경할 수 있게 처리할 수 있다.
		sb.append("a").append("b").append("c").append("d").append(false).append(5234).append("end");
		System.out.println(sb);
	}
}
