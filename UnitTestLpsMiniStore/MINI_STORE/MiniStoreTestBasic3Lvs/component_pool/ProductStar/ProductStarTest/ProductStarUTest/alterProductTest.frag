Fragment ProductStar-AlterProductTest { 
   Action: add
   Priority: high
   FragmentationPoints:paramsStart
   PointBracketsLan: java
   Destinations: Product-ProductTest
   SourceCode: [ALTERCODE-FRAG],12

[/ALTERCODE-FRAG]
}

Fragment ProductStar-AlterProductTest2 { 
   Action: add
   Priority: high
   FragmentationPoints:testProduct
   PointBracketsLan: java
   Destinations: Product-ProductTest
   SourceCode: [ALTERCODE-FRAG]	@Test
	public void verificacionStar() {
		assertEquals(12, producto.getStar());

		producto.setStar(10);
		assertEquals(10, producto.getStar());

	}
[/ALTERCODE-FRAG]
}

