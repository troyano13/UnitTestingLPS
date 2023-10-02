package controllers;

import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import models.CommentDAO;
import models.Product;
import models.ProductDAO;
/*B-importTest-zone*/

public class ListProductsTest {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private RequestDispatcher requestDispatcher;


	@Before
	public void setUp() {
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		requestDispatcher = Mockito.mock(RequestDispatcher.class);
	}

	@Test
	public void testDoGetWithIdParameter() throws ServletException, IOException {
		when(request.getParameter("id")).thenReturn("1");
		Mockito.when(request.getRequestDispatcher("views/oneproduct.jsp")).thenReturn(requestDispatcher);

		Product mockedProduct = new Product(1, "Sample Product", 10, "Description");

		mockStatic(ProductDAO.class);
		when(ProductDAO.getProductByID(1)).thenReturn(mockedProduct);

		CommentDAO commentDAO = Mockito.mock(CommentDAO.class);

		ListProducts listProductsServlet = new ListProducts();
		listProductsServlet.init();
		listProductsServlet.doGet(request, response);

		Mockito.verify(request).setAttribute("title", "Sample Product");
		Mockito.verify(request).setAttribute("pro", mockedProduct);
		Mockito.verify(request).setAttribute("id", "1");
		Mockito.verify(requestDispatcher).forward(request, response);
	}
	/*B-oneproductTest-zone*/

	@Test
	public void testDoGetWithoutIdParameter() throws ServletException, IOException {
		Mockito.when(request.getParameter("id")).thenReturn(null);
		Mockito.when(request.getRequestDispatcher("views/listproducts.jsp")).thenReturn(requestDispatcher);

		List<Product> mockedProducts = new ArrayList<>();
		mockedProducts.add(new Product(1, "Product 1", 10, "Description 1"));
		mockedProducts.add(new Product(2, "Product 2", 20, "Description 2"));

		ProductDAO productDAO = Mockito.mock(ProductDAO.class);
		Mockito.when(productDAO.getProducts()).thenReturn((ArrayList<Product>) mockedProducts);

		CommentDAO commentDAO = Mockito.mock(CommentDAO.class);

		ListProducts listProductsServlet = new ListProducts();
		listProductsServlet.init();
		listProductsServlet.doGet(request, response);

		Mockito.verify(request).setAttribute("title", "Products");
		Mockito.verify(request).setAttribute("products", mockedProducts);
		Mockito.verify(requestDispatcher).forward(request, response);
	}
	/*B-methodTest-zone*/
}
