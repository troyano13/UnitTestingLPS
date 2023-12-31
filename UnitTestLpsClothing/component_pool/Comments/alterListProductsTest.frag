Fragment Comments-AlterListProductsTest { 
   Action: add
   Priority: high
   FragmentationPoints: importTest-zone
   PointBracketsLan: java
   Destinations: ListOfProducts-ListProductsTest
   SourceCode: [ALTERCODE-FRAG]
import models.ProductDAO;
 [/ALTERCODE-FRAG]
}

Fragment Comments-AlterListProductsTest2 { 
   Action: add
   Priority: high
   FragmentationPoints: oneproductTest-zone
   PointBracketsLan: java
   Destinations: ListOfProducts-ListProductsTest
   SourceCode: [ALTERCODE-FRAG]@Test
	public void testDoGetComments() throws ServletException, IOException {

		Mockito.when(request.getRequestDispatcher("/listproducts.jsp")).thenReturn(requestDispatcher);
		Product mockedProduct = new Product(1, "Products", 10, "Description");
		listProductsController.doGet(request, response);

		Mockito.verify(request).setAttribute("title", "Products");
	}
[/ALTERCODE-FRAG]
}