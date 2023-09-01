Fragment Login-AlterAdminTest { 
   Action: add
   Priority: high
   FragmentationPoints: loginTest-zone
   PointBracketsLan: java
   Destinations: BasicViewsAdmin-HomeTest, CommentManagement-ManageCommentTest, ProductManagement-ManageProductsTest, UserManagement-ManageUsersTest
   SourceCode: [ALTERCODE-FRAG] User adminUser = new User("Admin User", "admin", "adminuser", "adminpass");
        when(session.getAttribute("datauser")).thenReturn(adminUser);[/ALTERCODE-FRAG]
}