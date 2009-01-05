import groovy.sql.Sql

// Create connection
def sql = Sql.newInstance(/jdbc:derby:C:\Program Files\Sun\JavaDB\demo\databases\toursdb/, "APP",
                      "APP", "org.apache.derby.jdbc.EmbeddedDriver")

println "*".multiply(5)

//Execute SQL and iterate over result set.
sql.eachRow("select * from CITIES") {
    println "${it.city_name}, ${it.country}"
}

println "*".multiply(5)

//Execute SQL and iterate over result set.
sql.eachRow("select * from CITIES") {row ->
    println "${row[1]}, ${row[2]}"
}

println "*".multiply(5)
                      
// Execute SQL and iterate over result set.
sql.eachRow("select * from CITIES where Language='English' order by COUNTRY") {
    println "${it.city_name}, ${it.country}"
}

println "*".multiply(5)

