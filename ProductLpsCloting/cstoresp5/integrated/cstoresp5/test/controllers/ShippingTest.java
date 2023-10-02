package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ShippingTest {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestDispatcher requestDispatcher;
    private Shipping shippingController;

    @Before
    public void setUp() {
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        requestDispatcher = Mockito.mock(RequestDispatcher.class);
        shippingController = new Shipping();
    }

    @Test
    public void testDoGet() throws ServletException, IOException {
       
    	Mockito.when(request.getRequestDispatcher("views/shipping.jsp")).thenReturn(requestDispatcher);

        shippingController.doGet(request, response);

        Mockito.verify(request).setAttribute("title", "Shipping");
       
        //Mockito.verify(requestDispatcher).forward(request, response);
    }
}

