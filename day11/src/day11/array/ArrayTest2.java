package day11.array;

public class ArrayTest2 {
	public static void main(String[] args) {
		int a[]={62,70,57,248,68,258,10,27,257,127,8,368,10,479,4,369,1,57,164,10,369,258,14,146,};
		ArrayTest2 at = new ArrayTest2();
		int sum = at.sumArray(a);
		double avg = at.avgArray(a);
		System.out.println(sum);
		System.out.println(avg);
		System.out.println("---------가장 첫번째----------");
		int index = at.findTen(a);
			if(index!=-1){
				System.out.println("10은 "+(index+1)+"번에 있습니다.");
			}else{
				System.out.println("10이 없습니다.");
			}
			System.out.println("--------모두 찾기---------");
			int[] index2 = at.findAllTen(a);
			int count=0;
			if(index2[0]!=0){
				for(int i =0;index2[i]!=0;i++){
					System.out.println("10은 "+(index2[i]+1)+"번에 있습니다.");
					count=i;
				}
			}else{
				System.out.println("10이 없습니다.");
			}
			System.out.println("총"+(count+1)+"개 입니다.");
			System.out.println("-------------------향상 for----------");
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
		// 향상된 for문은 자바 1.5버전에서만 사용가능, 배열, 컬랙션 내 모든 값 조회.
		int [] intArr={247,257,25,46,45,5,5,46,82,46,346,156,146};
		int sum=0;
		for(int i:intArr){ // i 조회되는 배열 내의 값을 저장할 변수
			sum+=i;
			System.out.println(i);
		}
		System.out.println(sum);
	}
	
	
	
	public int[] findAllTen(int[] arr){
		//10이 몇개인지 알 수 없기 때문에 동일한 크기로 지정
		//반복문을 이용한 10의 개수를 확인 후 개수로 배열 크기 지정하는것이 더 좋음
		int index[]=new int[arr.length];
		//값이 10인지 비교하기 위한 임시 변수 temp
		int temp;
		//해당 값이 적절한 index 배열 위치로 찾게 하기 위한 변수 j
		int j=0;
			//반복문으로 arr배열의 각 값이 10인지 비교함.
				for(int i=0;i<arr.length;i++){
					temp = arr[i]; //각 값 temp에 임시 저장
					if(temp==10){ 
						index[j++] = i; //해당 값이 10인 경우 몇번째에 있는 값인지 index에 저장 
						//j++은 index 배열 위치 변경
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
