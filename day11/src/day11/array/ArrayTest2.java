package day11.array;

public class ArrayTest2 {
	public static void main(String[] args) {
		int a[]={62,70,57,248,68,258,10,27,257,127,8,368,10,479,4,369,1,57,164,10,369,258,14,146,};
		ArrayTest2 at = new ArrayTest2();
		int sum = at.sumArray(a);
		double avg = at.avgArray(a);
		System.out.println(sum);
		System.out.println(avg);
		System.out.println("---------���� ù��°----------");
		int index = at.findTen(a);
			if(index!=-1){
				System.out.println("10�� "+(index+1)+"���� �ֽ��ϴ�.");
			}else{
				System.out.println("10�� �����ϴ�.");
			}
			System.out.println("--------��� ã��---------");
			int[] index2 = at.findAllTen(a);
			int count=0;
			if(index2[0]!=0){
				for(int i =0;index2[i]!=0;i++){
					System.out.println("10�� "+(index2[i]+1)+"���� �ֽ��ϴ�.");
					count=i;
				}
			}else{
				System.out.println("10�� �����ϴ�.");
			}
			System.out.println("��"+(count+1)+"�� �Դϴ�.");
			System.out.println("-------------------��� for----------");
			at.newFor();
	}
		
	public int findTen(int[] arr){
		int index = -1;
		int temp;
				for(int i=0;i<arr.length;i++){
					temp = arr[i];
					if(temp==10){
						index = i;
						break;
					}
				}
			return index;
	}
	public void newFor(){
		// ���� for���� �ڹ� 1.5���������� ��밡��, �迭, �÷��� �� ��� �� ��ȸ.
		int [] intArr={247,257,25,46,45,5,5,46,82,46,346,156,146};
		int sum=0;
		for(int i:intArr){ // i ��ȸ�Ǵ� �迭 ���� ���� ������ ����
			sum+=i;
			System.out.println(i);
		}
		System.out.println(sum);
	}
	
	
	
	public int[] findAllTen(int[] arr){
		//10�� ����� �� �� ���� ������ ������ ũ��� ����
		//�ݺ����� �̿��� 10�� ������ Ȯ�� �� ������ �迭 ũ�� �����ϴ°��� �� ����
		int index[]=new int[arr.length];
		//���� 10���� ���ϱ� ���� �ӽ� ���� temp
		int temp;
		//�ش� ���� ������ index �迭 ��ġ�� ã�� �ϱ� ���� ���� j
		int j=0;
			//�ݺ������� arr�迭�� �� ���� 10���� ����.
				for(int i=0;i<arr.length;i++){
					temp = arr[i]; //�� �� temp�� �ӽ� ����
					if(temp==10){ 
						index[j++] = i; //�ش� ���� 10�� ��� ���°�� �ִ� ������ index�� ���� 
						//j++�� index �迭 ��ġ ����
					}
				}
			return index;
	}
	
	public int sumArray(int[] array){
		int sum=0;
		for(int i=0;i<array.length;i++){
			sum+=array[i];
		}
		return sum;
	}
	
	public double avgArray(int[] array){
		return (double)sumArray(array)/array.length;
	}	
}
