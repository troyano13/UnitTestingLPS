package controllers;

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

import models.User;
import models.UserDAO;

public class LoginTest {

	private Login loginController;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private RequestDispatcher dispatcher;
	private User user;

	@Before
	public void setUp() {
		loginController = new Login();
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		session = mock(HttpSession.class);
		user = mock(User.class);
		dispatcher = mock(RequestDispatcher.class);


		when(request.getSession()).thenReturn(session);
		when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
	}

	@Test
	public void testDoGet() throws ServletException, IOException {
		when(request.getParameter("logout")).thenReturn("1");

		loginController.doGet(request, response);

		verify(session).removeAttribute("logged");
		verify(session).removeAttribute("user");
		verify(session).removeAttribute("admin");
		verify(session).removeAttribute("datauser");
		verify(response).sendRedirect(eq("Home"));
	}



}