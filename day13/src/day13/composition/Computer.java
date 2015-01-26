package day13.composition;

public class Computer {
	private String maker;
	private int price;
	private Cpu cpu; // Computer(whole) has a Cpu(part)
						// Composition : whole ��ü�� �����ɶ� part�� ��ü�� instance ������
						// ���ԵǾ����
						// public Computer(){} �̷��� ���� �ȵ�.

	public Computer(String maker, int price, Cpu cpu) {
		this.maker = maker;
		this.price = price;
		this.cpu = cpu;
	}

	public Computer(Cpu cpu) {
		if(cpu != null){
		this.cpu = cpu;
		}else{
			this.cpu = new Cpu("��������","��������","��������");
		}
	}
	public Computer(){
		this.cpu = new Cpu("��������","��������","��������");
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Cpu getCpu() {
		return cpu;
	}

	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}

	@Override
	public String toString() {
		return "����Ŀ : " + maker + ",  ���� : " + price + ",   cpu���� : " + cpu;
	}

}
