
Fragment ProductVIP-AlterProductVIPTest { 
   Action: add
   Priority: high
   FragmentationPoints: paramsVIP
   PointBracketsLan: java
   Destinations: Product-ProductTest
   SourceCode: [ALTERCODE-FRAG],true
[/ALTERCODE-FRAG]
}

Fragment ProductVIP-AlterProductVIPTest2 { 
   Action: add
   Priority: high
   FragmentationPoints: testProduct
   PointBracketsLan: java
   Destinations: Product-ProductTest
   SourceCode: [ALTERCODE-FRAG]@Test
	public void verificacionVip() {
		assertEquals(true, producto.isVip());

	}
[/ALTERCODE-FRAG]
}




