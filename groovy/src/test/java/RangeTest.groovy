 class RangeTest extends GroovyTestCase { 
 
   def lowerCaseRange = 'a'..'z' 
   def upperCaseRange = 'A'..'Z' 
 
   void testLowerCaseRange() { 

     assert 26 == lowerCaseRange.size() 
     assertTrue(lowerCaseRange.contains('b')) 
     assertFalse(lowerCaseRange.contains('B')) 
   } 
 
   void testUpperCaseRange() { 
     assert 26 == upperCaseRange.size() 
     assertTrue(upperCaseRange.contains('B')) 
     assertFalse(upperCaseRange.contains('b')) 
   } 
 
   void testAlphaRange() { 
     def alphaRange = lowerCaseRange + upperCaseRange 
     assert 52 == alphaRange.size() 
     assert alphaRange.contains('b') 
     assert alphaRange.contains('B') 
   } 
 } 
