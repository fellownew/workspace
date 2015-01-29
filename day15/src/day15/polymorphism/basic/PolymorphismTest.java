package day15.polymorphism.basic;

import java.util.ArrayList;
import java.util.Date;

import day15.inheritance.overriding.Animal;
import day15.inheritance.overriding.Dog;
import day15.inheritance.overriding.Koala;
import day15.inheritance.overriding.Lion;
import day15.inheritance.overriding.Penguin;

public class PolymorphismTest {
	public static void main(String[] args) {
		PolymorphismTest pt1 = new PolymorphismTest();
		pt1.basicTest();
		System.out.println("---heterogeneous---");
		pt1.heterogeneousTest();
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		pt1.polymorphicArgument1(new Lion());
		pt1.polymorphicArgument1(new Dog());
		pt1.polymorphicArgument1(new Koala());
		pt1.polymorphicArgument1(new Penguin());
		System.out.println("===================");
		pt1.instanceofTest(new Dog());
		pt1.instanceofTest(new Lion());
		Animal an1 = new Dog();
		pt1.instanceofTest(an1);
		Animal an2 = new Animal();
		pt1.instanceofTest(an2);
	}
	//polymorphicArgument1 : 다형성을 매개변수에 적용한것, 매개변수를 부모타입으로 정의하면 그 하위의 모든 객체를 다 받을 수 있는 것.
	
	public void polymorphicArgument1(Animal an){
	an.eat();
	}
	public void instanceofTest(Animal an){
		
		
		
		if(an instanceof Dog){
			((Dog) an).bark();
		}else if(an instanceof Lion){
			((Lion) an).hunt();
		}else if(an instanceof Animal){
			an.eat();
		}else{
			System.out.println("아무것도 안합니다.");
		}
		
	}
	public void basicTest(){
		//다형성 : 부모타입 변수 = 자식타입객체
		Animal a1 = new Animal();
		Animal a2 = new Lion();
		Animal a3 = new Dog();
		
		System.out.println("----eat 메소드!----");
		a1.eat();
		a2.eat();
		a3.eat();
		System.out.println("----따로있는 메소드!----");
//		a2.hunt(); Animal 타입이기때문에 hunt()를 Animal클래스에서 검색함. 때문에 컴파일 에러.
//		a3.bark(); 위와 동일한 이유로 컴파일 에러.
		((Lion)a2).hunt();
		Dog d1 = (Dog)a3;
		d1.bark();
		
	}
	public void heterogeneousTest(){
		//Heterogeneous Collection : 다른 타입의 값을 모아서 관리하는 배열 - 배열에 다형성을 적용.
		Animal[] aArr = new Animal[3];
		aArr[0]=new Animal();
		aArr[1]=new Dog();
		aArr[2]=new Lion();
		for(int i =0;i<aArr.length;i++){
			aArr[i].eat();
		}
		Animal[] aArr2 = {new Dog(),new Dog(),new Lion(),new Koala()};
		System.out.println("----------코알라 포함 -----------");
		for(Animal an:aArr2){
			an.sleep();
			an.eat();
			System.out.println("**");
		}
		//java.lang.Object - 모든 객체의 최상위 타입.
		Object[] oArr = new Object[5];
		oArr[0] = "asdlkgas";
		oArr[1] = new Dog();
		oArr[2] = new PolymorphismTest();
		oArr[3] = new Date();
		oArr[4] = new ArrayList();
		for(Object o:oArr){
			String s = o.toString();
			System.out.println(s);
		}
		
	}
}