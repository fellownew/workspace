package test;

import java.util.Random;

public class Test {
	public static void main(String[] args){
		int[] ranNum = new int[3];
		Random random = new Random();
		while(true){
			for (int idx = 0; idx < ranNum.length; idx++) {
				ranNum[idx] = random.nextInt(9)+1;
				for (int idx2 = 0; idx2 < idx; idx2++) {
					if (ranNum[idx] == ranNum[idx2]) {
						ranNum[idx] = random.nextInt(9)+1;
						idx2--;
					}
				}
			}
			for(int i = 0;i<ranNum.length;i++){
				System.out.print(ranNum[i]);
			}
			System.out.println();
		}
	}
}