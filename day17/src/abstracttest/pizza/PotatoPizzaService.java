package abstracttest.pizza;

public class PotatoPizzaService extends PizzaService {

	@Override
	public void Prepare() {
		System.out.println("감자를 준비");
	}

	@Override
	public void topping() {
		System.out.println("감자 올리기");
	}

	@Override
	public void bake() {
		System.out.println("30분 굽기");
	}
}
