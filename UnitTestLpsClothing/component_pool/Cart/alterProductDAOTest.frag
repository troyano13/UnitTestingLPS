Fragment Cart-AlterProductDAOTest { 
   Action: add
   Priority: high
   FragmentationPoints: methodTest-zone
   PointBracketsLan: java
   Destinations: ProductModel-ProductDAOTest
   SourceCode: [ALTERCODE-FRAG]@Test
	public void testGetProductByID() throws SQLException {
		when(statement.executeQuery(anyString())).thenReturn(resultSet);

		int ids = 1;
		ArrayList<Product> products = ProductDAO.getProductsByIds("1");

		assertEquals(ProductDAO.getProductByID(ids),null);
	}[/ALTERCODE-FRAG]
}

