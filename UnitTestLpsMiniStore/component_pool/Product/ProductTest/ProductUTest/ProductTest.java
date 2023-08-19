package test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import main.Product;

public class ProductTest {


	Product producto = new Product(10,"carmen",9/*B-paramsVIP*/ /*B-paramsStart*/ );
	
	
	/*B-testProduct*/
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
