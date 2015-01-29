package animal.service;
import animal.vo.Animal;
import animal.vo.Dog;
import animal.vo.Koala;

//������(animalŸ�� ��ü)���� �ϴ� Ŭ����
// -animal Ÿ���� ��ü���� �̿��� �����Ͻ� ������ ó���ϴ� Ŭ����
public class AnimalService {
	Animal[] ani;
	int anicount;
	public AnimalService(){
		ani=new Animal[100];
	}
	public AnimalService(int length){
		ani = new Animal[length];
	}
	//���� �߰�
	public void addAnimal(Animal an){
		int count =1;
		for(int i=0;i<ani.length;i++,count++){
			if(ani[i]==null){
				ani[i]=an;
				break;
			}
		}
		System.out.println(an+"�� "+count+"��°�� �����ϴ�.");
	}
	//���� �߰�2, �迭�� ���� �߰�
	public void addAnimal2(Animal an){
		ani[anicount]=an;
		anicount++;
	}
	
	//��� ���� �� ���̱�
	public void foodAllAnimal(){
		if(ani[0]==null){
			System.out.println("���̸� ���� ������ �����ϴ�.");
		}
		for(int i=0;i<ani.length;i++){
			if(ani[i]==null){
				break;
			}
			System.out.print(ani[i].getName()+"   ");
			ani[i].eat();
		}
	}
	
	//��� ���� ���
	public void removeAllanimal(){
		for(int i=0;i<ani.length;i++){
			if(ani[i]==null){
				break;
			}
			ani[i]=null;
		}
		System.out.println("��� ���");
	}
	//idx ��°�� �ִ� ������ ����
	public void delAnimal(int idx){
		for(int i = idx-1;i<ani.length-1;i++){
			ani[i]=ani[i+1];
		}
	}
	
	//�� ã��
	public Dog[] findAllDog(Animal ani[]){
		System.out.println("---Dog �˻� ���---");
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
	
	//�ھ˶� ã��
	public Koala[] findAllKoala(Animal ani[]){
		System.out.println("---Koala �˻� ���---");
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
	
	//����Ʈ
	public static void print(Animal ani[]){
		int count = 0;
		for(int i=0;i<ani.length;i++){
			if(ani[i]==null){
				break;
			}
				System.out.println(ani[i]);
				count++;
			}
		System.out.println("�� "+count+"���� �Դϴ�");
	}
}
