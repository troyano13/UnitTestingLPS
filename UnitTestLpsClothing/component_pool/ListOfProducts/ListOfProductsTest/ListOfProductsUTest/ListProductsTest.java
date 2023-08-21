
import static org.mockito.Mockito.*;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import controllers.ListProducts;
import models.Product;
import models.ProductDAO;

public class ListProductsTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher requestDispatcher;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDoGetWithIdParameter() throws ServletException, IOException {
        when(request.getParameter("id")).thenReturn("1");
        when(request.getRequestDispatcher("views/oneproduct.jsp")).thenReturn(requestDispatcher);

        Product mockedProduct = new Product();
        mockedProduct.setName("Sample Product");
        when(ProductDAO.getProductByID(1)).thenReturn(mockedProduct);

        ListProducts listProductsServlet = new ListProducts();
        listProductsServlet.doGet(request, response);

        verify(request).setAttribute("title", "Sample Product");
        verify(request).setAttribute("pro", mockedProduct);
        verify(request).setAttribute("id", "1");
        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testDoGetWithoutIdParameter() throws ServletException, IOException {
        when(request.getParameter("id")).thenReturn(null);
        when(request.getRequestDispatcher("views/listproducts.jsp")).thenReturn(requestDispatcher);

        ListProducts listProductsServlet = new ListProducts();
        listProductsServlet.doGet(request, response);

        verify(request).setAttribute("title", "Products");
        verify(requestDispatcher).forward(request, response);
    }
}


