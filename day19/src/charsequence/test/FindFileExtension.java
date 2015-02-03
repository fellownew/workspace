package charsequence.test;

public class FindFileExtension {
	public static void main(String[] args) {
		printFileExtension("영화 15.01.01.avi");
		printFileExtension("설명서.txt");
		printFileExtension("ReadMe");
	}
	public static void printFileExtension(String fileName){
		//매개변수로 받은 파일 명에서 파일의 확장자만 찾아 출력하도록 구현하세요.
		int idx = fileName.lastIndexOf(".");
		if(idx==-1){
			System.out.println("확장자가 없어요");
			return;
		}
		System.out.println(fileName.substring(idx+1));
	}
}