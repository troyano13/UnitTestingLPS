Fragment Login-AlterAccountTest { 
   Action: add
   Priority: high
   FragmentationPoints: loginTest-zone
   PointBracketsLan: java
   Destinations: Account-AccountTest
   SourceCode: [ALTERCODE-FRAG]when(session.getAttribute("datauser")).thenReturn(user);[/ALTERCODE-FRAG]
}