Fragment ProductVIP-AlterProductVIP { 
   Action: add
   Priority: high
   FragmentationPoints: attributes
   PointBracketsLan: java
   Destinations: Product-Model
   SourceCode: [ALTERCODE-FRAG]
	private boolean vip;[/ALTERCODE-FRAG]
}

Fragment ProductVIP-AlterProductVIP2 { 
   Action: add
   Priority: high
   FragmentationPoints: methods
   PointBracketsLan: java
   Destinations: Product-Model
   SourceCode: [ALTERCODE-FRAG]
	public boolean isVip() {
	return vip;
}
[/ALTERCODE-FRAG]
}

Fragment ProductVIP-AlterProductVIP3 { 
   Action: add
   Priority: high
   FragmentationPoints: methods
   PointBracketsLan: java
   Destinations: Product-Model
   SourceCode: [ALTERCODE-FRAG]
	public void setVip(boolean vip) {
	this.vip = vip;
}[/ALTERCODE-FRAG]
}

Fragment ProductVIP-AlterProductVIP4 { 
   Action: add
   Priority: low
   FragmentationPoints:  paramsPVIP
   PointBracketsLan: java
   Destinations: Product-Model
   SourceCode: [ALTERCODE-FRAG]
, boolean vip
[/ALTERCODE-FRAG]
}
Fragment ProductVIP-AlterProductVIP5 { 
   Action: add
   Priority: low
   FragmentationPoints: params-assign
   PointBracketsLan: java
   Destinations: Product-Model
   SourceCode: [ALTERCODE-FRAG]
	this.vip = vip;[/ALTERCODE-FRAG]
}


