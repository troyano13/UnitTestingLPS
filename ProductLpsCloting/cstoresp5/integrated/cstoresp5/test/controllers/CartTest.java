package controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;

public class CartTest {

    private Cart cartController;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestDispatcher dispatcher;
    private HttpSession session;

    @Before
    public void setUp() {
        cartController = new Cart();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        dispatcher = mock(RequestDispatcher.class);
        session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
    }

    @Test
    public void testDoGet() throws ServletException, IOException {
        Map<Integer, String> pincart = new HashMap<>();
        when(session.getAttribute("pincart")).thenReturn(pincart);

        cartController.doGet(request, response);

        verify(request).setAttribute(eq("title"), eq("Cart"));
        verify(request).setAttribute(eq("products"), any());
        verify(request).setAttribute(eq("qty"), eq(pincart));
        verify(dispatcher).forward(request, response);
    }

    @Test
    public void testDoPost() throws ServletException, IOException {
        Map<Integer, String> pincart = new HashMap<>();
        when(session.getAttribute("pincart")).thenReturn(pincart);

        when(request.getParameter("id")).thenReturn("123");
        when(request.getParameter("qty")).thenReturn("2");

        cartController.doPost(request, response);

        assertEquals("2", pincart.get(123));
        verify(session).setAttribute(eq("pincart"), eq(pincart));
        verify(response).sendRedirect(eq("Cart"));
    }

    @Test
    public void testGetIds() {
        Map<Integer, String> pincart = new HashMap<>();
        pincart.put(1, "3");
        pincart.put(2, "1");
        String expectedIds = "1,2";

        String ids = cartController.getIds(pincart);

        assertEquals(expectedIds, ids);
    }


}
