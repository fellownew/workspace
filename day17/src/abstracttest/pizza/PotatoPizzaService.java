package abstracttest.pizza;

public class PotatoPizzaService extends PizzaService {

	@Override
	public void Prepare() {
		System.out.println("���ڸ� �غ�");
	}

	@Override
	public void topping() {
		System.out.println("���� �ø���");
	}

	@Override
	public void bake() {
		System.out.println("30�� ����");
	}
}
