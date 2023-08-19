package test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import main.Product;

public class ProductTest {


	Product producto = new Product(10,"carmen",9/*B-paramsVIP*/

/*Code injected by: ProductVIP-AlterProductVIPTest*/
,true
/*Code injected by: ProductVIP-AlterProductVIPTest*/
 /*B-paramsStart*/

/*Code injected by: ProductStar-AlterProductTest*/
,12
/*Code injected by: ProductStar-AlterProductTest*/
 );
	
	
	/*B-testProduct*/

/*Code injected by: ProductStar-AlterProductTest2*/
@Test
	public void verificacionStar() {
		assertEquals(12, producto.getStar());

		producto.setStar(10);
		assertEquals(10, producto.getStar());

	}
/*Code injected by: ProductStar-AlterProductTest2*/


/*Code injected by: ProductVIP-AlterProductVIPTest2*/
@Test
	public void verificacionVip() {
		assertEquals(true, producto.isVip());

	}
/*Code injected by: ProductVIP-AlterProductVIPTest2*/

	@Test
	public void verificacionId() {
		assertEquals(10, producto.getId());

		producto.setId(10);
		assertEquals(10, producto.getId());

	} 

	@Test
	public void verificacionName() {
		assertEquals("carmen", producto.getName());

		producto.setName("Teresa");
		assertEquals("Teresa", producto.getName());

	}

	@Test
	public void verificacionPrice() {
		assertEquals(9, producto.getPrice());

		producto.setPrice(10);
		assertEquals(10, producto.getPrice());

	}



}
