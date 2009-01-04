def writer = new StringWriter() 
def builder = new groovy.xml.MarkupBuilder(writer) 
builder.setDoubleQuotes(true) 
builder.authors { 
     author(id:"1") { 
         firstName "Chris" 
         lastName "Judd" 
     } 
     author(id:"2") { 
         firstName "Jim" 
         lastName "Shingler" 
     } 
     author(id:"3") { 
         firstName "Joseph" 
         lastName "Nusirat" 
     } 
 } 
 
println writer.toString() 
new File(/C:\temp\authors.xml/).text = writer.toString()
