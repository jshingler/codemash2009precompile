
public class Student {

	String firstName
	String lastName

	String toString() {
		"${lastName}, ${firstName}"
	}
	
	def homework() { "homework..." }
	
	def studies = ['Math', 'History', 'Lunch']
	
	def methodMissing(String name, args) 
	{ 
		println "methodMissing called for $name" 
		def methodInList = studies.find { it == name.split('study')[1]} 
		if (methodInList) { 
			return "studying ${name.split('study')[1]}..." 
		} else { 
			throw new MissingMethodException(name, Student.class, args) 
		} 
	} 
}


student = new Student(firstName: "Chris", lastName: "Judd") 
println student.homework() 
println student.studyMath() 
println student.studyHistory() 
println student.studyLunch() 

try { 
	student.sleepInClass() 
} catch(Exception ex) { 
	println "Error: " + ex 
} 
