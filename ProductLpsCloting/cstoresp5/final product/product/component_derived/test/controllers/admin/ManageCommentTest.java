package controllers.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ManageCommentTest {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private RequestDispatcher requestDispatcher;
	private ManageComment manageCommentController;

	@Before
	public void setUp() {
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		requestDispatcher = Mockito.mock(RequestDispatcher.class);
		manageCommentController = new ManageComment();
	}

	@Test
	public void testDoPost() throws ServletException, IOException {
		Mockito.when(request.getParameter("product")).thenReturn("1");
		Mockito.when(request.getParameter("description")).thenReturn("New Comment");

		manageCommentController.doPost(request, response);

		Mockito.verify(request).getParameter("product");
		Mockito.verify(request).getParameter("description");
		//  Mockito.verify(CommentDAO.class).insert(Mockito.any(Comment.class));
		Mockito.verify(response).sendRedirect("Comments");
	}
}
