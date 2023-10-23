package controllers.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Comment;
import models.CommentDAO;
import models.User;

@WebServlet(urlPatterns = {"/Admin/Comments"})
public class ManageComment  extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	/*B-login-zone*/

/*Code injected by: Login-AlterAdmin*/
HttpSession session = request.getSession();
    	User u = (User) session.getAttribute("datauser");
    	if(u == null) { response.sendRedirect("../Home"); return;	}
    	else if(!u.getType().equals("admin")){
    		response.sendRedirect("../Home"); return;
    	}
/*Code injected by: Login-AlterAdmin*/

    	
    	String remove = request.getParameter("remove");
		if(remove != null){
			CommentDAO.remove(Integer.parseInt(remove));
		}
    	
    	request.setAttribute("comments",CommentDAO.getComments());
    	request.setAttribute("title", "Admin Panel - Comments");
        RequestDispatcher view = request.getRequestDispatcher("../admin/comments.jsp");
        view.forward(request, response);
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException {
		String product = request.getParameter("product");
		String desc = request.getParameter("description");
		
		Comment c = new Comment(Integer.parseInt(product),desc);
		CommentDAO.insert(c);
		response.sendRedirect("Comments");
	}

}
