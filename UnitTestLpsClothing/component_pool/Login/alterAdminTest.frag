Fragment Login-AlterAdminTest { 
   Action: add
   Priority: high
   FragmentationPoints: import-zone
   PointBracketsLan: java
   Destinations: BasicViewsAdmin-HomeTest, CommentManagement-ManageCommentTest, ProductManagement-ManageProductsTest, UserManagement-ManageUsersTest
   SourceCode: [ALTERCODE-FRAG] import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import models.User;
import static org.mockito.Mockito.when;[/ALTERCODE-FRAG]
}

Fragment Login-AlterAdminTest2 { 
   Action: add
   Priority: high
   FragmentationPoints: homeTest-zone
   PointBracketsLan: java
   Destinations: BasicViewsAdmin-HomeTest, CommentManagement-ManageCommentTest, ProductManagement-ManageProductsTest, UserManagement-ManageUsersTest
   SourceCode: [ALTERCODE-FRAG] @Test
	public void testDoGetHome() throws ServletException, IOException {
		User user = new User("Test User", "user", "datauser", "testpass");

		when(session.getAttribute("datauser")).thenReturn(user);

		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

		homeServlet.doGet(request, response);

		verify(request).setAttribute(eq("title"), eq("cStores"));
		// verify(request).setAttribute(eq("datauser"), eq(user));
		verify(dispatcher).forward(request, response);
	}[/ALTERCODE-FRAG]
}


