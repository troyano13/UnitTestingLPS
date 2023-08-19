Fragment ProductVIP-AlterIndexVIPTest { 
   Action: add
   Priority: high
   FragmentationPoints: paramsIVIP
   PointBracketsLan: java
   Destinations: Index-IndexTest
   SourceCode: [ALTERCODE-FRAG]
,true
[/ALTERCODE-FRAG]
}

Fragment ProductVIP-AlterIndexVIPTest2 { 
   Action: add
   Priority: high
   FragmentationPoints: testIndex
   PointBracketsLan: java
   Destinations: Index-IndexTest
   SourceCode: [ALTERCODE-FRAG]
@Test
	public void verificacionVip() {
		assertEquals(true, p1.isVip());

	}

[/ALTERCODE-FRAG]
}