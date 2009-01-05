String.metaClass.contents = { 
  this.class.getResourceAsStream(delegate).getText() 
} 
 
def write = { file -> 
  println file 
} 
 
write 'configuration.properties'.contents() 
