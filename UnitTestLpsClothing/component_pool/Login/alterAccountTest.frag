Fragment Login-AlterAccount { 
   Action: add
   Priority: high
   FragmentationPoints: loginTest-zone
   PointBracketsLan: java
   Destinations: Account\AccountTest\AccountUTest-AccountTest
   SourceCode: [ALTERCODE-FRAG]when(session.getAttribute("datauser")).thenReturn(user);[/ALTERCODE-FRAG]
}