import com.juddsolutions.groovy.basics.Student

def student = new Student(firstName:"Chris", lastName:"Judd")

println student

// determine properties at runtime
println "\nProperties:"
student.metaClass.properties.each {println it.name}
	
println()

// determine methods at runtime
println "Methods:"
student.metaClass.methods.each {println it.name}

