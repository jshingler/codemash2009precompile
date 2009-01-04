/**
 * Simple JavaBean for showing the comparison with
 * Groovy code and GroovyBeans.
 */

package com.juddsolutions.groovy.basics;

import java.util.ArrayList;
import java.util.List;

public class Student2 {

	private String firstName;
	private String lastName;
	
	public Student2(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public static void main(String[] args) {
		List<Student2> students = new ArrayList<Student2>();
		students.add(new Student2("Chris", "Judd"));
		students.add(new Student2("Jim", "Shingler"));
		students.add(new Student2("Joseph", "Nusairat"));
		
		System.out.println("Students:");
		for (Student2 student : students) {
			System.out.println(student.getLastName() + ", " + student.getFirstName());
		}
	}
}
