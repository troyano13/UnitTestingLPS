package controllers.admin;

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

public class HomeTest {

	private Home servletHome;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;

	@Before
	public void setUp() {
		servletHome = new Home();
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		session = mock(HttpSession.class);

		when(request.getSession()).thenReturn(session);
	}

    @Test
    public void testDoGet() throws ServletException, IOException {
        User user = new User(1, "test", "user", "admin", "123");
        
        when(session.getAttribute("datauser")).thenReturn(user);

		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

		servletHome.doGet(request, response);
        
		verify(request).setAttribute(eq("title"), eq("admin"));
		verify(request).setAttribute(eq("user"), eq(user));
		verify(dispatcher).forward(request, response);
		
    }
}
