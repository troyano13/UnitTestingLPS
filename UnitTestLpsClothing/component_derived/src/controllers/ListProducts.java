package controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Product;
import models.ProductDAO;
/*B-import-zone*/

/*Code injected by: Comments-AlterListProducts*/
import models.CommentDAO;
/*Code injected by: Comments-AlterListProducts*/


@WebServlet(urlPatterns = {"/Products"})
public class ListProducts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	RequestDispatcher view;
    	
    	if (request.getParameter("id") != null){
    		String id = request.getParameter("id");

            /*B-oneproduct-zone*/

/*Code injected by: Comments-AlterListProducts2*/
request.setAttribute("comments",CommentDAO.getCommentsByPID(Integer.parseInt(id)));
/*Code injected by: Comments-AlterListProducts2*/

    		
    		Product pro=ProductDAO.getProductByID(Integer.parseInt(id));          
            request.setAttribute("title", pro.getName());
            request.setAttribute("pro",pro);
            request.setAttribute("id",id);
            view = request.getRequestDispatcher("views/oneproduct.jsp");
    		
    	}else{     
            request.setAttribute("title", "Products");      
            request.setAttribute("products",ProductDAO.getProducts());
    
            view = request.getRequestDispatcher("views/listproducts.jsp");
        }
        view.forward(request, response);  
    }

    /*B-method-zone*/

/*Code injected by: Rating-AlterListProducts*/
public void doPost( HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {

		String n = request.getParameter("rating");
		String id = request.getParameter("id");

		Product pro=ProductDAO.getProductByID(Integer.parseInt(id));
		pro.setTotal_rates(pro.getTotal_rates()+Integer.parseInt(n));
		pro.setNum_rates(pro.getNum_rates()+1);
		ProductDAO.updateRating(pro);
		
		response.sendRedirect("Products?id="+pro.getId());
    }
/*Code injected by: Rating-AlterListProducts*/

    
    
}
