package controllers.admin;

import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;

import controllers.admin.Home;
import models.User;

public class HomeTest {

    private Home homeServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    @Before
    public void setUp() {
        homeServlet = new Home();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
    }

   
    @Test
    public void testDoGet() throws ServletException, IOException {
		
		 /*B-loginTest-zone*/
   
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        homeServlet.doGet(request, response);

        verify(request).setAttribute(eq("title"), eq("Admin Panel"));
        verify(dispatcher).forward(request, response);
    }



}
