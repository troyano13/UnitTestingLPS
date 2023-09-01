package controllers.admin;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; // Importante importar HttpSession
import java.io.IOException;

public class HomeTest {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestDispatcher requestDispatcher;
    private Home servlet;

    @Before
    public void setUp() {
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        requestDispatcher = Mockito.mock(RequestDispatcher.class);
        servlet = new Home();
    }

    @Test
    public void testDoGet() throws ServletException, IOException {
        HttpSession session = Mockito.mock(HttpSession.class); // Crear mock de HttpSession
        Mockito.when(request.getRequestDispatcher("admin/home.jsp")).thenReturn(requestDispatcher);
        Mockito.when(request.getSession()).thenReturn(session); // Establecer sesión en la solicitud

        // Configurar el comportamiento del HttpSession mock
        Mockito.when(session.getAttribute("datauser")).thenReturn("someValue"); // Reemplaza "someValue" con el valor esperado

        servlet.doGet(request, response);

        Mockito.verify(session).setAttribute("title", "Admin Panel");
        Mockito.verify(requestDispatcher).forward(request, response);
    }
}
