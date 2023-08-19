package main;

public class Index {
	public static void main(String[] args) {
		/*BCP-store-name*/
		System.out.println("Welcome to the store called: XXXXXXX");
		/*ECP-store-name*/
		System.out.println("Check the new product:");
		/*B-productobject*/
		Product p1=new Product(1,"TV 50",100 /*B-paramsIndex*/

/*Code injected by: ProductStar-AlterIndex*/
,5
/*Code injected by: ProductStar-AlterIndex*/


/*Code injected by: ProductVIP-AlterIndexVIP*/
,true
/*Code injected by: ProductVIP-AlterIndexVIP*/
);
		/*E-productobject*/
		System.out.println(p1.getName() + " - price " + p1.getPrice());
	}
}
