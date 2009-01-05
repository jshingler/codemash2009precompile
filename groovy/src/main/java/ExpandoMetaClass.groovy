Class.metaClass.getResourceAsText = { resource -> 
  this.class.getResourceAsStream(resource).getText() 
} 
 
def text = this.class.getResourceAsText('configuration.properties') 
println text