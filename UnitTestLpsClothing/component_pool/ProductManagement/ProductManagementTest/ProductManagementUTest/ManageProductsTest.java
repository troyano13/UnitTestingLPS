import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;

import controllers.admin.ManageProducts;
import models.Product;
import models.ProductDAO;
import models.User;

public class ManageProductsTest {

    private ManageProducts manageProductsServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    /*B-loginTest-zone*/

    @Before
    public void setUp() {
        manageProductsServlet = new ManageProducts();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
    }

    @Test
    public void testDoGet() throws ServletException, IOException {
        User adminUser = new User("Admin User", "admin", "adminuser", "adminpass");
        when(session.getAttribute("datauser")).thenReturn(adminUser);

        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        manageProductsServlet.doGet(request, response);

        verify(request).setAttribute(eq("products"), any());
        verify(request).setAttribute(eq("title"), eq("Admin Panel - Products"));
        verify(dispatcher).forward(request, response);
    }

    @Test
    public void testDoPost() throws ServletException, IOException {
        when(request.getParameter("name")).thenReturn("New Product");
        when(request.getParameter("description")).thenReturn("New Product Description");
        when(request.getParameter("price")).thenReturn("100");
        when(request.getParameter("img")).thenReturn("newproduct.jpg");

        manageProductsServlet.doPost(request, response);

        verify(response).sendRedirect("Products");
    }


}
