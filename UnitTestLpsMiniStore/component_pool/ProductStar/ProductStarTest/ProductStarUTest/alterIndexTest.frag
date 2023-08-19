Fragment ProductStar-AlterIndexTest { 
   Action: add
   Priority: high
   FragmentationPoints:paramsIStart
   PointBracketsLan: java
   Destinations: Index-IndexTest
   SourceCode: [ALTERCODE-FRAG] 
 ,12
		
[/ALTERCODE-FRAG]
}
Fragment ProductStar-AlterIndexTest2 { 
   Action: add
   Priority: high
   FragmentationPoints:testIndex
   PointBracketsLan: java
   Destinations: Index-IndexTest
   SourceCode: [ALTERCODE-FRAG] 
@Test
	public void verificacionStar() {
		assertEquals(12, p1.getStar());

		p1.setStar(10);
		assertEquals(10, p1.getStar());
	}
		
[/ALTERCODE-FRAG]
}