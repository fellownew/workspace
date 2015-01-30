package abstracttest.pizza;

public abstract class PizzaService {
	public void makePizza(int num){
		System.out.println("���ڸ� ����ϴ�.");
		Prepare();
		topping();
		bake();
		cut(num);
		System.out.println("---�ϼ�---");
	}
	
	public abstract void Prepare();
	public abstract void topping();
	public abstract void bake();

	public void cut(int num){
		System.out.println(num+"�������� �߶����ϴ�.");
	}
}