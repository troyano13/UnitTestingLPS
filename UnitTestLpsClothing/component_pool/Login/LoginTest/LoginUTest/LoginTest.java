package controllers;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;

import models.User;
import models.UserDAO;

public class LoginTest {

    private Login loginServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private RequestDispatcher dispatcher;
    private User user;

    @Before
    public void setUp() {
        loginServlet = new Login();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        user = mock(User.class);
        dispatcher = mock(RequestDispatcher.class);


        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
    }

    @Test
    public void testDoGet() throws ServletException, IOException {
        when(request.getParameter("logout")).thenReturn("1");

        loginServlet.doGet(request, response);

        verify(session).removeAttribute("logged");
        verify(session).removeAttribute("user");
        verify(session).removeAttribute("admin");
        verify(session).removeAttribute("datauser");
        verify(response).sendRedirect(eq("Home"));
    }

    @Test
    public void testDoPostWithValidUser() throws ServletException, IOException {
        when(request.getParameter("user")).thenReturn("testuser");
        when(request.getParameter("pass")).thenReturn("testpass");
        when(UserDAO.getOneUser("testuser", "testpass")).thenReturn(user);

        when(user.getType()).thenReturn("user");

        loginServlet.doPost(request, response);

        verify(session).setAttribute("user", "1");
        verify(session).setAttribute("datauser", user);
        verify(session).setAttribute("logged", "1");
        verify(response).sendRedirect(eq("Home"));
    }
    
    @Test
    public void testDoPost() throws ServletException, IOException {
        Map<Integer, String> pincart = new HashMap<>();
        when(session.getAttribute("pincart")).thenReturn(pincart);

        when(request.getParameter("user")).thenReturn("testuser");
        when(request.getParameter("pass")).thenReturn("testpass");

        loginServlet.doPost(request, response);

       // assertEquals("2", pincart.get(123));
        verify(session).setAttribute("user", "1");
        verify(session).setAttribute("datauser", user);
        verify(session).setAttribute("logged", "1");
        verify(response).sendRedirect(eq("Home"));
    }

    @Test
    public void testDoPostWithInvalidUser() throws ServletException, IOException {
        when(request.getParameter("user")).thenReturn("invaliduser");
        when(request.getParameter("pass")).thenReturn("invalidpass");
        when(UserDAO.getOneUser("invaliduser", "invalidpass")).thenReturn(null);

        
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        loginServlet.doPost(request, response);

        verify(response).sendRedirect(eq("Login"));
    }


}
