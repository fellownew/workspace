package abstracttest.pizza;

public class ShrimpPizzaService extends PizzaService {

	@Override
	public void Prepare() {
		System.out.println("새우 준비");
	}

	@Override
	public void topping() {
		System.out.println("새우 올리기");
	}

	@Override
	public void bake() {
		System.out.println("45분 굽기");
	}

}
