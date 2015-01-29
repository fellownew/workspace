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
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤ�");
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
	//polymorphicArgument1 : �������� �Ű������� �����Ѱ�, �Ű������� �θ�Ÿ������ �����ϸ� �� ������ ��� ��ü�� �� ���� �� �ִ� ��.
	
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
			System.out.println("�ƹ��͵� ���մϴ�.");
		}
		
	}
	public void basicTest(){
		//������ : �θ�Ÿ�� ���� = �ڽ�Ÿ�԰�ü
		Animal a1 = new Animal();
		Animal a2 = new Lion();
		Animal a3 = new Dog();
		
		System.out.println("----eat �޼ҵ�!----");
		a1.eat();
		a2.eat();
		a3.eat();
		System.out.println("----�����ִ� �޼ҵ�!----");
//		a2.hunt(); Animal Ÿ���̱⶧���� hunt()�� AnimalŬ�������� �˻���. ������ ������ ����.
//		a3.bark(); ���� ������ ������ ������ ����.
		((Lion)a2).hunt();
		Dog d1 = (Dog)a3;
		d1.bark();
		
	}
	public void heterogeneousTest(){
		//Heterogeneous Collection : �ٸ� Ÿ���� ���� ��Ƽ� �����ϴ� �迭 - �迭�� �������� ����.
		Animal[] aArr = new Animal[3];
		aArr[0]=new Animal();
		aArr[1]=new Dog();
		aArr[2]=new Lion();
		for(int i =0;i<aArr.length;i++){
			aArr[i].eat();
		}
		Animal[] aArr2 = {new Dog(),new Dog(),new Lion(),new Koala()};
		System.out.println("----------�ھ˶� ���� -----------");
		for(Animal an:aArr2){
			an.sleep();
			an.eat();
			System.out.println("**");
		}
		//java.lang.Object - ��� ��ü�� �ֻ��� Ÿ��.
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