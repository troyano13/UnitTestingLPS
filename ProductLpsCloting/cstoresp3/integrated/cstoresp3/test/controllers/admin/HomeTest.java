package controllers.admin;


/*B-import-zone*/
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import models.User;


public class HomeTest {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private RequestDispatcher requestDispatcher;
	private Home homeController;
	private HttpSession session;

	@Before
	public void setUp() {
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		requestDispatcher = Mockito.mock(RequestDispatcher.class);
		session = mock(HttpSession.class);
		homeController = new Home();
	}

	/*B-homeTest-zone*/


	@Test
	public void testDoGeft() throws Exception {
		Home homeServlet = new Home(); 

		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("datauser")).thenReturn(new User(0, "admin", "admin", null, null));
		when(request.getRequestDispatcher("../admin/index.jsp")).thenReturn(requestDispatcher);

		homeServlet.doGet(request, response);

		verify(request).setAttribute("title", "Admin Panel");
		verify(requestDispatcher).forward(request, response);

		verify(response, never()).sendRedirect("../Home");
	}

}
