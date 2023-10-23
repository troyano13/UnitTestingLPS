package models;

public class Product {
	private int id;
	private String name;
	private String description;
	private int price;
	private String img;
	/*B-attribute-zone*/

/*Code injected by: Rating-AlterProduct*/
private int num_rates;
	private int total_rates;
/*Code injected by: Rating-AlterProduct*/

	
	public Product(int id, String name, String description, int price, String img /*B-constructor-attribute-zone*/

/*Code injected by: Rating-AlterProduct2*/
, int num_rates, int total_rates
/*Code injected by: Rating-AlterProduct2*/
) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.img = img;
		/*B-constructor-inside-zone*/

/*Code injected by: Rating-AlterProduct3*/
this.num_rates = num_rates;
		this.total_rates = total_rates;
/*Code injected by: Rating-AlterProduct3*/

	}
	
	public Product(String name, String description, int price, String img /*B-constructor-attribute-zone2*/

/*Code injected by: Rating-AlterProduct2*/
, int num_rates, int total_rates
/*Code injected by: Rating-AlterProduct2*/
) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.img = img;
		/*B-constructor-inside-zone2*/

/*Code injected by: Rating-AlterProduct3*/
this.num_rates = num_rates;
		this.total_rates = total_rates;
/*Code injected by: Rating-AlterProduct3*/

	}

	public Product(int id, String name, int price, String img) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.img = img;
	}

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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getImg() {
		return img;
	}
	
	public void setImg(String img) {
		this.img = img;
	}

	/*B-method-zone*/

/*Code injected by: Rating-AlterProduct4*/
public int getNum_rates() {
		return num_rates;
	}

	public void setNum_rates(int num_rates) {
		this.num_rates = num_rates;
	}

	public int getTotal_rates() {
		return total_rates;
	}

	public void setTotal_rates(int total_rates) {
		this.total_rates = total_rates;
	}
	
	public int getRate() {
		if(num_rates==0){return 0;}
		return total_rates/num_rates;
	}
/*Code injected by: Rating-AlterProduct4*/


}
