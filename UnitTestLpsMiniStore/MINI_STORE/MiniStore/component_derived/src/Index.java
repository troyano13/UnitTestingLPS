
public class Index {
	public static void main(String[] args) {
		/*BCP-store-name*/
		System.out.println("Welcome to the store called: XXXXXXX");
		/*ECP-store-name*/
		System.out.println("Check the new product:");
		/*B-productobject*/

/*Code replaced by: ProductStar-AlterIndex*/
Product p1=new Product(1,"TV 50",100,5);
/*Code replaced by: ProductStar-AlterIndex*/
/*E-productobject*/
		System.out.println(p1.getName() + " - price " + p1.getPrice());
	}
}
