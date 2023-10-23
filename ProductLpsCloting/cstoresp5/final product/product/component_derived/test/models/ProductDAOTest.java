package models;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ProductDAOTest {

	@Mock
	private Connection conn;

	@Mock
	private Statement statement;

	@Mock
	private ResultSet resultSet;

	@Mock
	private ProductDAO productDAOController;

	private ProductDAO productDAO;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);	
		when(conn.createStatement()).thenReturn(statement);
		when(statement.executeQuery(anyString())).thenReturn(resultSet);

	}

	@Test
	public void testGetCommentsByPID() throws Exception {
		when(resultSet.next()).thenReturn(false);

		ArrayList<Product> product = productDAO.getProductsByIds("g");

		assertEquals(0, product.size());
	}
	/*B-methodTest-zone*/

/*Code injected by: Cart-AlterProductDAOTest*/
@Test
	public void testGetProductByID() throws SQLException {
		when(statement.executeQuery(anyString())).thenReturn(resultSet);

		int ids = 1;
		ArrayList<Product> products = ProductDAO.getProductsByIds("1");

		assertEquals(ProductDAO.getProductByID(ids),null);
	}
/*Code injected by: Cart-AlterProductDAOTest*/

	

}

