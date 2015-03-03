package test;

import java.util.Random;

public class Test {
	public static void main(String[] args){
		int a =0;
		Random random = new Random();
		while(a!=9){
			a = random.nextInt(10);
		System.out.println(a);
		}
	}
}