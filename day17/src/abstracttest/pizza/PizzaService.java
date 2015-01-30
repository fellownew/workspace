package abstracttest.pizza;

public abstract class PizzaService {
	public void makePizza(int num){
		System.out.println("피자를 만듭니다.");
		Prepare();
		topping();
		bake();
		cut(num);
		System.out.println("---완성---");
	}
	
	public abstract void Prepare();
	public abstract void topping();
	public abstract void bake();

	public void cut(int num){
		System.out.println(num+"조각으로 잘랐습니다.");
	}
}