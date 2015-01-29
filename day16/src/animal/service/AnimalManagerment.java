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
		as.addAnimal(new Dog("港港1",1,12.5,'∠'));
		as.addAnimal(new Dog("港港2",2,11.5,'∥'));
		as.addAnimal(new Dog("港港3",5,7.5,'∠'));
		as.addAnimal(new Koala("内舅1",5,8.4,'∠'));
		as.addAnimal(new Lion("绢蕊1",7,76.1,'∠',"剐覆"));
		as.addAnimal(new Koala("内舅2",8,6.6,'∠'));
		as.addAnimal(new Koala("内舅3",2,3.4,'∠'));
		as.findAllDog(as.ani);
		as.findAllKoala(as.ani);
		as.foodAllAnimal();
		as.delAnimal(3);
		as.foodAllAnimal();
	}
}
