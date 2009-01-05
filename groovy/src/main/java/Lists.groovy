def authors = []
authors.add 'Chris'
authors += 'Jim'
authors << 'Joseph'

println "Authors:"
authors.each{ println it }

println "type: ${authors.class.name}"
println "first author is ${authors[0]}"
println "last author is ${authors.last()}"

def books = [] as Set
books << "Enterprise Java Development on a Budget"
books << "Pro Eclipse JST"
books << "Beginning Groovy and Grails"

println"\nBooks:"
books.each {book -> println book}
println "type: ${books.class.name}"
