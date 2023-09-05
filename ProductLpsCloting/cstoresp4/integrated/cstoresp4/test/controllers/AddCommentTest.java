package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AddCommentTest {

	private HttpServletRequest request;
	private HttpServletResponse response;

	@Before
	public void setUp() {
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
	}

	@Test
	public void testDoPost() throws IOException, ServletException {
		Mockito.when(request.getParameter("product")).thenReturn("1");
		Mockito.when(request.getParameter("description")).thenReturn("This is a comment description.");

		AddComment addCommentServlet = new AddComment();

		addCommentServlet.doPost(request, response);
		//Mockito.verify(CommentDAO).insert(Mockito.any(Comment.class));

		Mockito.verify(response).sendRedirect("Products?id=1");
	}
}
