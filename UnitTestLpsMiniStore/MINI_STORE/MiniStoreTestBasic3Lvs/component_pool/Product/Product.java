package main;

public class Product {
	
	private int id;
	private String name;
	private int price;
	/*B-attributes*/

	/*B-methods*/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Product(int id, String name, int price /*B-paramsPVIP*/ /*B-paramsPStart*/ ) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		/*B-params-assign*/
	}
}