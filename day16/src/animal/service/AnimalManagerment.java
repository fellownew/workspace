package animal.service;

import animal.vo.Dog;
import animal.vo.Koala;
import animal.vo.Lion;

public class AnimalManagerment {
	public static void main(String[] args) {
		int select = 0;
		if(select==1){
			
		}else if(select==2){
			
		}else if(select==3){
			
		}
		AnimalService as = new AnimalService();
		as.addAnimal(new Dog("�۸�1",1,12.5,'��'));
		as.addAnimal(new Dog("�۸�2",2,11.5,'��'));
		as.addAnimal(new Dog("�۸�3",5,7.5,'��'));
		as.addAnimal(new Koala("�ھ�1",5,8.4,'��'));
		as.addAnimal(new Lion("����1",7,76.1,'��',"�и�"));
		as.addAnimal(new Koala("�ھ�2",8,6.6,'��'));
		as.addAnimal(new Koala("�ھ�3",2,3.4,'��'));
		as.findAllDog(as.ani);
		as.findAllKoala(as.ani);
		as.foodAllAnimal();
		as.delAnimal(3);
		as.foodAllAnimal();
	}
}
