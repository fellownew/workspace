package composition;

public class Cpu {
	private String maker,brand,core;
	public Cpu(){}
	public Cpu(String maker, String brand, String core) {
		this.maker = maker;
		this.brand = brand;
		this.core = core;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCore() {
		return core;
	}
	public void setCore(String core) {
		this.core = core;
	}
	@Override
	public String toString() {
		return "[메이커 = " + maker + ", 브랜드 = " + brand + ", 코어 = " + core+"]";
	}
	
	
}
