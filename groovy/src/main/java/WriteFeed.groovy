import groovy.sql.Sql

def sql = Sql.newInstance(/jdbc:derby:C:\temp\blogs/, "APP",
                      "APP", "org.apache.derby.jdbc.EmbeddedDriver")

def writer = new StringWriter() 
def builder = new groovy.xml.MarkupBuilder(writer) 
builder.setDoubleQuotes(true) 
builder.feeds { 
	sql.eachRow("select * from blogs") { row -> 
		feed(id:row.id) { 
			title row.title 
		} 
	}                       
}

println writer.toString()

println "done"