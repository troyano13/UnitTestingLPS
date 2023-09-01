package controllers.admin;

import models.Comment;
import models.CommentDAO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManageCommentTest {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestDispatcher requestDispatcher;
    private ManageComment servlet;

    @Before
    public void setUp() {
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        requestDispatcher = Mockito.mock(RequestDispatcher.class);
        servlet = new ManageComment();
    }

    @Test
    public void testDoGet() throws ServletException, IOException {
        List<Comment> comments = new ArrayList<>();
        comments.add(new Comment(1, "Comment 1"));
        comments.add(new Comment(2, "Comment 2"));
        Mockito.when(request.getParameter("remove")).thenReturn(null);
       // Mockito.when(CommentDAO.getComments()).thenReturn(comments);
        Mockito.when(request.getRequestDispatcher("../views/admin/comments.jsp")).thenReturn(requestDispatcher);

        servlet.doGet(request, response);

        Mockito.verify(request).setAttribute("comments", comments);
        Mockito.verify(request).setAttribute("title", "Admin Panel - Comments");
        Mockito.verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testDoPost() throws ServletException, IOException {
        Mockito.when(request.getParameter("product")).thenReturn("1");
        Mockito.when(request.getParameter("description")).thenReturn("New Comment");

        servlet.doPost(request, response);

        Mockito.verify(request).getParameter("product");
        Mockito.verify(request).getParameter("description");
      //  Mockito.verify(CommentDAO.class).insert(Mockito.any(Comment.class));
        Mockito.verify(response).sendRedirect("Comments");
    }
}
