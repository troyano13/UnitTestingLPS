Fragment Rating-AlterListProducts { 
  

}

Fragment Rating-AlterListProductsTest { 
   Action: add
   Priority: high
   FragmentationPoints: importTest-zone
   PointBracketsLan: java
   Destinations: ListOfProducts-ListOfProductsTest
   SourceCode: [ALTERCODE-FRAG]import models.ProductDAO;

[/ALTERCODE-FRAG]
}

Fragment Rating-AlterListProductsTest1 { 
   Action: add
   Priority: high
   FragmentationPoints: twoproductTest-zone
   PointBracketsLan: java
   Destinations: ListOfProducts-ListOfProductsTest
   SourceCode: [ALTERCODE-FRAG] 
@Test
	public void testDoGetComments() throws ServletException, IOException {

		Mockito.when(request.getRequestDispatcher("/listproducts.jsp")).thenReturn(requestDispatcher);
		Product mockedProduct = new Product(1, "Products", 10, "Description");
		listProductsController.doGet(request, response);

		Mockito.verify(request).setAttribute("title", "Products");
	}

[/ALTERCODE-FRAG]
}