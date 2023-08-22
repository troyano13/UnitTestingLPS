
Fragment Rating-AlterProductTest { 
   Action: add
   Priority: high
   FragmentationPoints: paramsTest-attribute-zone
   PointBracketsLan: java
   Destinations: ProductModel/ProductModelTest/ProductModelUTest-ProductTest
   SourceCode: [ALTERCODE-FRAG], 5, 20
[/ALTERCODE-FRAG]
}

Fragment Rating-AlterProduct2 { 
   Action: add
   Priority: high
   FragmentationPoints: methodTest-zone
   PointBracketsLan: java
   Destinations: ProductModel/ProductModelTest/ProductModelUTest-ProductTest
   SourceCode: [ALTERCODE-FRAG] @Test
    public void testGetNumRates() {
        assertEquals(5, product.getNum_rates());
    }

    @Test
    public void testGetTotalRates() {
        assertEquals(20, product.getTotal_rates());
    }

    @Test
    public void testGetRate() {
        assertEquals(4, product.getRate());
    }
[/ALTERCODE-FRAG]
}
