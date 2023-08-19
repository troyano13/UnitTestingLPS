Fragment Login-AlterAdmin { 
   Action: add
   Priority: high
   FragmentationPoints: login-zone, login-zone, login-zone, login-zone
   PointBracketsLan: java
   Destinations: BasicViewsAdmin-Home, CommentManagement-ManageComment, ProductManagement-ManageProducts, UserManagement-ManageUsers
   SourceCode: [ALTERCODE-FRAG]HttpSession session = request.getSession();
    	User u = (User) session.getAttribute("datauser");
    	if(u == null) { response.sendRedirect("../Home"); return;	}
    	else if(!u.getType().equals("admin")){
    		response.sendRedirect("../Home"); return;
    	}[/ALTERCODE-FRAG]
}