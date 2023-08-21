import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

package models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

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

    @Test
    public void testGetRate() {
        assertEquals(4, product.getRate());
    }

    @Test
    public void testGetNumRates() {
        assertEquals(5, product.getNum_rates());
    }

    @Test
    public void testGetTotalRates() {
        assertEquals(20, product.getTotal_rates());
    }

    // Agrega más pruebas según sea necesario para otras funcionalidades

}


