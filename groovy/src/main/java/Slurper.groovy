def xml = """
<authors>
  <author id="1">
    <firstName>Chris</firstName>
    <lastName>Judd</lastName>
  </author>
  <author id="2"> 
    <firstName>Jim</firstName>
    <lastName>Shingler</lastName>
  </author>
  <author id="3">
    <firstName>Joseph</firstName>
    <lastName>Nusirat</lastName>
  </author>
</authors>
"""

def authors = new XmlSlurper().parseText(xml)
authors.author.each {author -> println "${author.@id} - ${author.lastName}, ${author.firstName}"}
