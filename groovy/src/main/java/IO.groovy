// write file
new File(/C:\temp\states.txt/).text = "Ohio"

// append file
def file = new File(/C:\temp\states.txt/)
file.append("\nTexas")


// read file
new File(/C:\temp\states.txt/).eachLine {line ->
	println line
}

// read file into String
def contents = new File(/C:\temp\states.txt/).text
println contents

// read file into List
def lines = new File(/C:\temp\states.txt/).readLines()
lines.each { println it }