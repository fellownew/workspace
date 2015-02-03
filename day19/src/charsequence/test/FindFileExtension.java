package charsequence.test;

public class FindFileExtension {
	public static void main(String[] args) {
		printFileExtension("��ȭ 15.01.01.avi");
		printFileExtension("����.txt");
		printFileExtension("ReadMe");
	}
	public static void printFileExtension(String fileName){
		//�Ű������� ���� ���� ���� ������ Ȯ���ڸ� ã�� ����ϵ��� �����ϼ���.
		int idx = fileName.lastIndexOf(".");
		if(idx==-1){
			System.out.println("Ȯ���ڰ� �����");
			return;
		}
		System.out.println(fileName.substring(idx+1));
	}
}