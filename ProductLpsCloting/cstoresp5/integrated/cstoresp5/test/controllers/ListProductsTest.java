package controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import controllers.ListProducts;
import models.Product;
import models.ProductDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ListProductsTest {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestDispatcher requestDispatcher;

    @Before
    public void setUp() {
        // Configura los mocks antes de cada prueba
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        requestDispatcher = Mockito.mock(RequestDispatcher.class);
    }

    @Test
    public void testDoGetWithIdParameter() throws ServletException, IOException {
        // Configura el comportamiento de los mocks
        Mockito.when(request.getParameter("id")).thenReturn("1");
        Mockito.when(request.getRequestDispatcher("views/oneproduct.jsp")).thenReturn(requestDispatcher);

        Product mockedProduct = new Product(1, "Sample Product", 10, "Description");
        
        // Mock de ProductDAO
        ProductDAO productDAO = Mockito.mock(ProductDAO.class);
        Mockito.when(productDAO.getProductByID(1)).thenReturn(mockedProduct);

        // Crea una instancia de ListProducts con el mock de ProductDAO
        ListProducts listProductsServlet = new ListProducts();
        
        listProductsServlet.doGet(request, response);

        // Verifica las interacciones con los mocks
        Mockito.verify(request).setAttribute("title", "Sample Product");
        Mockito.verify(request).setAttribute("pro", mockedProduct);
        Mockito.verify(request).setAttribute("id", "1");
        Mockito.verify(requestDispatcher).forward(request, response);
    }
}
