package controllers.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;
import models.UserDAO;

@WebServlet(urlPatterns = {"/Admin/Users"})
public class ManageUsers  extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	/*B-login-zone*/
    	
    	String remove = request.getParameter("remove");
		if(remove != null){
			UserDAO.remove(Integer.parseInt(remove));
		}
    	
    	request.setAttribute("users",UserDAO.getUsers());
    	request.setAttribute("title", "Admin Panel - Users");
        RequestDispatcher view = request.getRequestDispatcher("../admin/users.jsp");
        view.forward(request, response);
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		
		User u = new User(name,type,user,pass);
		UserDAO.insert(u);
		response.sendRedirect("Users");
	}
}
