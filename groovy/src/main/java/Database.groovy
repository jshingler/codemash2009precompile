import groovy.sql.Sql

// Create connection
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
blogs.add( id:"1", title: 'title 1' )
blogs.add( id:"2", title: 'title 2' )
blogs.add( id:"3", title: 'title 3' )

sql.executeInsert("insert into blogs values('4', 'title 4')")

println "Blogs:"
//Execute SQL and iterate over result set.
sql.eachRow("select * from blogs") { row -> 
    println "${row[0]}, ${row.title}"
}