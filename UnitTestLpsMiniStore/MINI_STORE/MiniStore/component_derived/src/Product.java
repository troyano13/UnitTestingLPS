
public class Product {
	
	private int id;
	private String name;
	private int price;
	/*B-attributes*/

/*Code injected by: ProductStar-AlterProduct1*/
private int star;
/*Code injected by: ProductStar-AlterProduct1*/


	/*B-methods*/

/*Code injected by: ProductStar-AlterProduct2*/
public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
/*Code injected by: ProductStar-AlterProduct2*/

	
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
	
	public Product(int id, String name, int price /*B-params*/

/*Code injected by: ProductStar-AlterProduct3*/
, int star
/*Code injected by: ProductStar-AlterProduct3*/
) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		/*B-params-assign*/

/*Code injected by: ProductStar-AlterProduct4*/
this.star = star;
/*Code injected by: ProductStar-AlterProduct4*/

	}
}