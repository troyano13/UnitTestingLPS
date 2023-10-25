package controllers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


import models.Product;

/*B-importTest-zone*/



public class ListProductsTest {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private RequestDispatcher requestDispatcher;
	private ListProducts listProductsController;

	@Before
	public void setUp() {
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		requestDispatcher = Mockito.mock(RequestDispatcher.class);
		listProductsController = new ListProducts();
	}

	@Test
	public void testDoGet() throws ServletException, IOException {

		Mockito.when(request.getRequestDispatcher("/listproducts.jsp")).thenReturn(requestDispatcher);
		listProductsController.doGet(request, response);
		Mockito.verify(request).setAttribute("title", "Products");
	}
	/*B-oneproductTest-zone*/

	
	/*B-twoproductTest-zone*/
}
