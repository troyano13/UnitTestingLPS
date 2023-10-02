Fragment Login-AlterAccountTest { 
   Action: add
   Priority: high
   FragmentationPoints: import-zone
   PointBracketsLan: java
   Destinations: Account-AccountTest
   SourceCode: [ALTERCODE-FRAG]import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import models.User;	[/ALTERCODE-FRAG]
}


Fragment Login-AlterAccountTest2 { 
   Action: add
   Priority: high
   FragmentationPoints: loginTest-zone
   PointBracketsLan: java
   Destinations: Account-AccountTest
   SourceCode: [ALTERCODE-FRAG]	@Test
	public void testDoGet() throws ServletException, IOException {
		User user = new User("Test User", "user", "testuser", "testpass");

		when(session.getAttribute("datauser")).thenReturn(user);

		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

		accountServlet.doGet(request, response);

		verify(request).setAttribute(eq("title"), eq("Account"));
		verify(request).setAttribute(eq("user"), eq(user));
		verify(dispatcher).forward(request, response);
	}[/ALTERCODE-FRAG]
}