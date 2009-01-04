/**
 * Simple JavaBean for showing the comparison with
 * Groovy code and GroovyBeans.
 */

package com.juddsolutions.groovy.basics;

public class Student {

	String firstName
	String lastName

	String toString() {
		"${lastName}, ${firstName}"
	}
}

def students = [
  new Student(firstName:"Chris", lastName:"Judd"),
  new Student(firstName:"Jim", lastName:"Shingler"),
  new Student(firstName:"Joseph", lastName:"Nusairat"),
]
		
println "Students:"
students.each {student ->
	println "${student.lastName}, ${student.firstName}"
}