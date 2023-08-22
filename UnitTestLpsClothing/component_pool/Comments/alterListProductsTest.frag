Fragment Comments-AlterListProducts { 
   Action: add
   Priority: high
   FragmentationPoints: import-zone
   PointBracketsLan: java
   Destinations: ListOfProducts/ListOfProductsTest/ListOfProductsUTest-ListProductsTest
   SourceCode: [ALTERCODE-FRAG]import models.Comment;
import models.CommentDAO;import java.util.ArrayList;
import java.util.List; [/ALTERCODE-FRAG]
}

Fragment Comments-AlterListProducts2 { 
   Action: add
   Priority: high
   FragmentationPoints: oneproduct-zone
   PointBracketsLan: java
   Destinations: ListOfProducts/ListOfProductsTest/ListOfProductsUTest-ListProductsTest
   SourceCode: [ALTERCODE-FRAG]@Test
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
    verify(request).setAttribute("comments", mockedComments); // Verifica que se haya establecido correctamente
    verify(requestDispatcher).forward(request, response);
} [/ALTERCODE-FRAG]
}