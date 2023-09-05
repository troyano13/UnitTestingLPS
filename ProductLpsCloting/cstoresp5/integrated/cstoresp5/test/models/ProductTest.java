package models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class ProductTest {

	private Product product;

	@Before
	public void setUp() {
		product = new Product(1, "Test Product", "Description", 100, "test.jpg"/*B-paramsTest-attribute-zone*/

/*Code injected by: Rating-AlterProductTest*/
, 5, 20
/*Code injected by: Rating-AlterProductTest*/
);
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

/*Code injected by: Rating-AlterProductTest2*/
@Test
    public void testGetNumRates() {
        assertEquals(5, product.getNum_rates());
    }

    @Test
    public void testGetTotalRates() {
        assertEquals(20, product.getTotal_rates());
    }

    @Test
    public void testGetRate() {
        assertEquals(4, product.getRate());
    }
/*Code injected by: Rating-AlterProductTest2*/



}


