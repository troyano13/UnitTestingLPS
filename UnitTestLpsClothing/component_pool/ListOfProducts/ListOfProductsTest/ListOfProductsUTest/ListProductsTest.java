package models;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class ProductTest {

	private Product product;

	@Before
	public void setUp() {
		product = new Product(1, "Test Product", "Description", 100, "test.jpg"/*B-paramsTest-attribute-zone*/);
	}

	@Test
	public void testGetId() {
		assertEquals(1, product.getId());
	}

	@Test
	public void testGetName() {
		assertEquals("Test Product", product.getName());
	}

	@Test
	public void testGetDescription() {
		assertEquals("Description", product.getDescription());
	}

	@Test
	public void testGetPrice() {
		assertEquals(100, product.getPrice());
	}

	@Test
	public void testGetImg() {
		assertEquals("test.jpg", product.getImg());
	}

	/*B-methodTest-zone*/


}


