package controllers;

import static org.mockito.Mockito.*;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

import models.Comment;
import models.CommentDAO;

public class AddCommentTest {

    private AddComment addCommentServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private CommentDAO commentDAO;
    private RequestDispatcher dispatcher;

    @Before
    public void setUp() {
        addCommentServlet = new AddComment();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        commentDAO = mock(CommentDAO.class);
        dispatcher = mock(RequestDispatcher.class);

        when(request.getParameter("product")).thenReturn("123"); // Cambia 123 por un valor válido
        when(request.getParameter("description")).thenReturn("Test description");

        addCommentServlet.setCommentDAO(commentDAO);
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
    }

    @Test
    public void testDoPost() throws ServletException, IOException {
        addCommentServlet.doPost(request, response);

        verify(commentDAO).insert(any(Comment.class));

        verify(response).sendRedirect("Products?id=123"); // Cambia 123 por el valor válido
    }


}