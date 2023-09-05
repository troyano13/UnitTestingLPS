package controllers.admin;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;

import models.User;

public class ManageUsersTest {

    private ManageUsers manageUsersServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    @Before
    public void setUp() {
        manageUsersServlet = new ManageUsers();
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

        manageUsersServlet.doGet(request, response);

        verify(request).setAttribute(eq("users"), any());
        verify(request).setAttribute(eq("title"), eq("Admin Panel - Users"));
        verify(dispatcher).forward(request, response);
    }

    @Test
    public void testDoPost() throws ServletException, IOException {
        when(request.getParameter("user")).thenReturn("newuser");
        when(request.getParameter("pass")).thenReturn("newpass");
        when(request.getParameter("name")).thenReturn("New User");
        when(request.getParameter("type")).thenReturn("user");

        manageUsersServlet.doPost(request, response);

        verify(response).sendRedirect("Users");
    }



}
