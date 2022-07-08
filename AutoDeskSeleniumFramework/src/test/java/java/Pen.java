package java;

public class Pen {

	private String color;
	private String brand;
	private int price;

	public Pen(String color,String brand,int price){
		this.color=color;
		this.brand=brand;
		this.price=price;
	}
	
		public String getColor() {
			return color;
		}

	public  void write() {
		System.out.println(color);
	}

}
