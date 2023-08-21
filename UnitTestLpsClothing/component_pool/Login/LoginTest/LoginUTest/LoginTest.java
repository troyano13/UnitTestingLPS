import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

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
    private User user;

    @Before
    public void setUp() {
        loginServlet = new Login();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        user = mock(User.class);

        when(request.getSession()).thenReturn(session);
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
    public void testDoPostWithInvalidUser() throws ServletException, IOException {
        when(request.getParameter("user")).thenReturn("invaliduser");
        when(request.getParameter("pass")).thenReturn("invalidpass");
        when(UserDAO.getOneUser("invaliduser", "invalidpass")).thenReturn(null);

        loginServlet.doPost(request, response);

        verify(response).sendRedirect(eq("Login"));
    }


}
