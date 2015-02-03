package charsequence.test;

public class StringBufferTest_template {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("good morning");
		sb.setLength(5);//sb의 글자수 5로 설정
		System.out.println(sb.length()); //sb길이 출력
		System.out.println(sb); //stringbuffer도 toString이 오버라이드 되어있음.
		
		sb.setCharAt(2,'c'); //sb 2인덱스 문자를 c로 변경
		System.out.println(sb); 
		
		System.out.println(sb.append("hi"));//sb에 hi 추가
		System.out.println(sb.insert(1,"lee"));//1번 인덱스부터 lee로 삽입(덮어쓰지 않음)
		
		System.out.println(sb.length());
		System.out.println(sb.capacity());	//현 버퍼의 크기 조회
		
		sb.setCharAt(1,'u');//1번 인덱스 u로 변경
		sb.append("kim");//kim 추가
		System.out.println(sb);
		StringBuffer sb1 = new StringBuffer("0123456789");
		sb1.delete(2, 5);//2~4인덱스 삭제
		System.out.println(sb1);
		sb1.replace(0, 2, "영일오");//0~2인덱스 영일오로 교체(0~1을 지우고 "영일오"를 삽입)
		System.out.println(sb1);
		System.out.println(sb1.length()+" - "+sb1.capacity());
		sb1.trimToSize();//버퍼 크기를 사용중인 크기로 재조정
		System.out.println(sb1.length()+" - "+sb1.capacity());
		//stringbuffer에서 equal()은 오버라이딩 되어있지 않음. equal로 비교하면 안됨.
		StringBuffer sb3 = new StringBuffer("abc");
		StringBuffer sb4 = new StringBuffer("abc");
		System.out.println(sb3.equals(sb4));
	}
}
