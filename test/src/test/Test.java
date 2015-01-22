package test;

public class Test {
	public static void main(String[] args) {
		int[] arr;
		int arr1[];
		int[] arr2 = new int[10];
		int a[]={5,3,2,4,1,6,8,7,9,2};
			for(int i=0;i<=10;i++){
				arr1[i]=(int)(Math.random()*101);
				arr2[i]=a[i]/10;
				System.out.println("a : "+a[i]);
				System.out.println("arr1 : "+arr1[i]);
				System.out.println("arr2 : "+arr2[i]);
			}
	}
}