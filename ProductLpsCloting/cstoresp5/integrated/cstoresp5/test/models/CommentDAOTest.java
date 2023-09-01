package models;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import models.Comment;

public class CommentDAOTest {

    @Mock
    private Connection conn;

    @Mock
    private Statement statement;

    @Mock
    private ResultSet resultSet;

    private CommentDAO commentDAO;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks

        when(conn.createStatement()).thenReturn(statement);
        when(statement.executeQuery(anyString())).thenReturn(resultSet);

        commentDAO = new CommentDAO();
       // commentDAO.setConnection(conn);
    }

    @Test
    public void testGetCommentsByPID() throws Exception {
        when(resultSet.next()).thenReturn(false);

        ArrayList<Comment> comments = commentDAO.getCommentsByPID(1);

        assertEquals(0, comments.size());
    }


}
