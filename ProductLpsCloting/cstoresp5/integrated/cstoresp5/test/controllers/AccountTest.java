package controllers;

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

	@Test
	public void testDoGet() throws ServletException, IOException {
		User user = new User("Test User", "user", "testuser", "testpass");
		/*B-loginTest-zone*/

/*Code injected by: Login-AlterAccountTest*/
when(session.getAttribute("datauser")).thenReturn(user);
/*Code injected by: Login-AlterAccountTest*/


		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

		accountServlet.doGet(request, response);

		verify(request).setAttribute(eq("title"), eq("Account"));
		verify(request).setAttribute(eq("user"), eq(user));
		verify(dispatcher).forward(request, response);
	}


}