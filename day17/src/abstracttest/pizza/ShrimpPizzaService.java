package abstracttest.pizza;

public class ShrimpPizzaService extends PizzaService {

	@Override
	public void Prepare() {
		System.out.println("���� �غ�");
	}

	@Override
	public void topping() {
		System.out.println("���� �ø���");
	}

	@Override
	public void bake() {
		System.out.println("45�� ����");
	}

}
