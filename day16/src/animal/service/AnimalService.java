package animal.service;
import animal.vo.Animal;
import animal.vo.Dog;
import animal.vo.Koala;

//동물들(animal타입 객체)관리 하는 클래스
// -animal 타입의 객체들을 이용해 비지니스 로직을 처리하는 클래스
public class AnimalService {
	Animal[] ani;
	int anicount;
	public AnimalService(){
		ani=new Animal[100];
	}
	public AnimalService(int length){
		ani = new Animal[length];
	}
	//동물 추가
	public void addAnimal(Animal an){
		int count =1;
		for(int i=0;i<ani.length;i++,count++){
			if(ani[i]==null){
				ani[i]=an;
				break;
			}
		}
		System.out.println(an+"은 "+count+"번째에 들어갔습니다.");
	}
	//동물 추가2, 배열에 동물 추가
	public void addAnimal2(Animal an){
		ani[anicount]=an;
		anicount++;
	}
	
	//모든 동물 밥 먹이기
	public void foodAllAnimal(){
		if(ani[0]==null){
			System.out.println("먹이를 먹을 동물이 없습니다.");
		}
		for(int i=0;i<ani.length;i++){
			if(ani[i]==null){
				break;
			}
			System.out.print(ani[i].getName()+"   ");
			ani[i].eat();
		}
	}
	
	//모든 동물 방생
	public void removeAllanimal(){
		for(int i=0;i<ani.length;i++){
			if(ani[i]==null){
				break;
			}
			ani[i]=null;
		}
		System.out.println("모두 방생");
	}
	//idx 번째에 있는 동물만 삭제
	public void delAnimal(int idx){
		for(int i = idx-1;i<ani.length-1;i++){
			ani[i]=ani[i+1];
		}
	}
	
	//개 찾기
	public Dog[] findAllDog(Animal ani[]){
		System.out.println("---Dog 검색 결과---");
		Dog[] d = new Dog[100];
		int count = 0;
		for(int i=0;i<ani.length;i++){
			if(ani[i] instanceof Dog){
				d[count]=(Dog)ani[i];
				count++;
			}
		}
		print(d);
		return d;
	}
	
	//코알라 찾기
	public Koala[] findAllKoala(Animal ani[]){
		System.out.println("---Koala 검색 결과---");
		Koala[] k = new Koala[100];
		int count = 0;
		for(int i=0;i<ani.length;i++){
			if(ani[i] instanceof Koala){
				k[count]=(Koala)ani[i];
				count++;
			}
		}
		print(k);
		return k;
	}
	
	//프린트
	public static void print(Animal ani[]){
		int count = 0;
		for(int i=0;i<ani.length;i++){
			if(ani[i]==null){
				break;
			}
				System.out.println(ani[i]);
				count++;
			}
		System.out.println("총 "+count+"마리 입니다");
	}
}
