package controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeTest {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestDispatcher requestDispatcher;
    private Home homeController;

    @Before
    public void setUp() {
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        requestDispatcher = Mockito.mock(RequestDispatcher.class);
        homeController = new Home();
    }

    @Test
    public void testDoGet() throws ServletException, IOException {
        Mockito.when(request.getRequestDispatcher("views/index.jsp")).thenReturn(requestDispatcher);

        homeController.doGet(request, response);

        Mockito.verify(request).setAttribute("title", "cStores");
        Mockito.verify(requestDispatcher).forward(request, response);
    }
}
