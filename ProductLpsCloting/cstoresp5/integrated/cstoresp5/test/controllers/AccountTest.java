package controllers;

/*B-import-zone*/

/*Code injected by: Login-AlterAccountTest*/
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import models.User;
/*Code injected by: Login-AlterAccountTest*/


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {

	private Account accountServlet;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;

	@Before
	public void setUp() {
		accountServlet = new Account();
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		session = mock(HttpSession.class);

		when(request.getSession()).thenReturn(session);
	}
	/*B-loginTest-zone*/

/*Code injected by: Login-AlterAccountTest2*/
@Test
	public void testDoGet() throws ServletException, IOException {
		User user = new User("Test User", "user", "testuser", "testpass");

		when(session.getAttribute("datauser")).thenReturn(user);

		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

		accountServlet.doGet(request, response);

		verify(request).setAttribute(eq("title"), eq("Account"));
		verify(request).setAttribute(eq("user"), eq(user));
		verify(dispatcher).forward(request, response);
	}
/*Code injected by: Login-AlterAccountTest2*/


	@Test
	public void testDoGetRedirectToHome() throws Exception {

		when(session.getAttribute("datauser")).thenReturn(null);
		accountServlet.doGet(request, response);

		verify(response).sendRedirect("Home");
	}

}