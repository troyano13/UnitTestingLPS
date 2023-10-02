package controllers;

/*B-import-zone*/

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

	@Test
	public void testDoGetRedirectToHome() throws Exception {

		when(session.getAttribute("datauser")).thenReturn(null);
		accountServlet.doGet(request, response);

		verify(response).sendRedirect("Home");
	}

}