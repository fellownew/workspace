package day13.composition;

public class Computer {
	private String maker;
	private int price;
	private Cpu cpu; // Computer(whole) has a Cpu(part)
						// Composition : whole 객체가 생성될때 part의 객체가 instance 변수에
						// 대입되어야함
						// public Computer(){} 이렇게 들어가면 안됨.

	public Computer(String maker, int price, Cpu cpu) {
		this.maker = maker;
		this.price = price;
		this.cpu = cpu;
	}

	public Computer(Cpu cpu) {
		if(cpu != null){
		this.cpu = cpu;
		}else{
			this.cpu = new Cpu("정보없음","정보없음","정보없음");
		}
	}
	public Computer(){
		this.cpu = new Cpu("정보없음","정보없음","정보없음");
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
		return "메이커 : " + maker + ",  가격 : " + price + ",   cpu정보 : " + cpu;
	}

}
