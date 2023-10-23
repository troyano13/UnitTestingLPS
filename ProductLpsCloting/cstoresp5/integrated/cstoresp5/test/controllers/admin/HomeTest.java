package controllers.admin;


/*B-import-zone*/
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


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

	@Test
	public void testDoGet() throws ServletException, IOException {
		Mockito.when(request.getRequestDispatcher("views/index.jsp")).thenReturn(requestDispatcher);

		//homeController.doGet(request, response);

		//verify(request).setAttribute("title", "cStores");
		//verify(requestDispatcher).forward(request, response);
	}

	/*B-homeTest-zone*/




}
