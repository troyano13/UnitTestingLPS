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

/*Code injected by: Comments-AlterListProductsTest*/
import models.Comment;
import models.CommentDAO;import java.util.ArrayList;
import java.util.List;
/*Code injected by: Comments-AlterListProductsTest*/


@WebServlet(urlPatterns = {"/Products"})
public class ListProductsTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	RequestDispatcher view;
    	
    	if (request.getParameter("id") != null){
    		String id = request.getParameter("id");

            /*B-oneproduct-zone*/

/*Code injected by: Comments-AlterListProductsTest2*/
@Test
public void testDoGetWithIdParameterC() throws ServletException, IOException {
    when(request.getParameter("id")).thenReturn("1");
    when(request.getRequestDispatcher("views/oneproduct.jsp")).thenReturn(requestDispatcher);

    Product mockedProduct = new Product(1, "Sample Product", "Sample Description", 100, "sample_image.jpg");
    when(ProductDAO.getProductByID(1)).thenReturn(mockedProduct);

    List<Comment> mockedComments = new ArrayList<>();
    mockedComments.add(new Comment(1, 1, "Comment 1", "2023-08-12"));
    mockedComments.add(new Comment(2, 1, "Comment 2", "2023-08-13"));
    when(CommentDAO.getCommentsByPID(1)).thenReturn(mockedComments);

    ListProducts listProductsServlet = new ListProducts();
    listProductsServlet.doGet(request, response);

    verify(request).setAttribute("title", "Sample Product");
    verify(request).setAttribute("pro", mockedProduct);
    verify(request).setAttribute("id", "1");
    verify(request).setAttribute("comments", mockedComments); 
    verify(requestDispatcher).forward(request, response);
}
/*Code injected by: Comments-AlterListProductsTest2*/

    		
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

/*Code injected by: Rating-AlterListProductsTest*/
auqi va algo
    }
/*Code injected by: Rating-AlterListProductsTest*/

    
    
}
