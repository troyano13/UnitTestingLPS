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
    private CommentDAO CommentDAO;
    private RequestDispatcher dispatcher;

    @Test
    public void testDofPost() throws ServletException, IOException {
        // Mock de los objetos HttpServletRequest, HttpServletResponse y RequestDispatcher
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);

        // Configurar el comportamiento de los métodos del request
        when(request.getParameter("product")).thenReturn("1");
        when(request.getParameter("description")).thenReturn("This is a comment.");

        // Configurar el comportamiento de request.getRequestDispatcher
        when(request.getRequestDispatcher("views/your_redirect_page.jsp")).thenReturn(requestDispatcher);

        // Crear una instancia de la clase AddComment
        AddComment addCommentServlet = new AddComment();

        // Llamar al método doPost
        addCommentServlet.doPost(request, response);

        // Verificar que CommentDAO.insert fue llamado con el comentario correcto
        verify(CommentDAO).insert(argThat(comment -> comment.getProduct() == 1 && comment.getDescription().equals("This is a comment.")));

        // Verificar que se redirige a la página esperada
        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testDoPost() throws ServletException, IOException {
        addCommentServlet.doPost(request, response);

        verify(CommentDAO).insert(any(Comment.class));

        verify(response).sendRedirect("Products?id=123"); // Cambia 123 por el valor válido
    }


}