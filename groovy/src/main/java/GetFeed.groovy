import groovy.sql.Sql

def feed = new URL("http://juddsolutions.blogspot.com/feeds/posts/default").text

//println feed

//def file = new File("C:\\temp\\feed.xml")
//file.text = feed

def sql = Sql.newInstance(/jdbc:derby:C:\temp\blogs;create=true/, "APP",
                      "APP", "org.apache.derby.jdbc.EmbeddedDriver")

// delete table if previously created
try {
   sql.execute("drop table blogs")
} catch(Exception e){}

// create table
sql.execute('''create table blogs (
    id varchar(200) not null primary key,
    title varchar(500)
)''')

// populate the table
def blogs = sql.dataSet("blogs")

feed = new XmlSlurper().parseText(feed)
feed.entry.each {entry -> 
  println "reading - ${entry.id} ${entry.title}"
  blogs.add( id: entry.id.text(), title: entry.title.text() )
}




println "done"