Fragment Login-AlterAdmin { 
   Action: add
   Priority: high
   FragmentationPoints: loginTest-zone
   PointBracketsLan: java
   Destinations: BasicViewsAdmin\BasicViewAdminTest\BasicViewAdminUTest-HomeTest, CommentManagement-ManageComment, ProductManagement-ManageProducts, UserManagement-ManageUsers
   SourceCode: [ALTERCODE-FRAG] User adminUser = new User("Admin User", "admin", "adminuser", "adminpass");
        when(session.getAttribute("datauser")).thenReturn(adminUser);[/ALTERCODE-FRAG]
}