package abstracttest.pizza;

public class PizzaTest {
	public static void main(String[] args) {
		PizzaService ps = new PotatoPizzaService();
		PizzaService ps2 = new ShrimpPizzaService();
		ps.makePizza(8);
		ps2.makePizza(8);
	}
}
