class Person {

	String firstName
	String lastName
    Person spouse
	
	String toString() {
		"${lastName}, ${firstName}"
	}
	
	Person leftShift(partner) {
		partner.lastName = lastName
		spouse = partner
		partner.spouse = this
	}
}

def husband = new Person(firstName:"Chris", lastName:"Judd")
def wife = new Person(firstName: "Sue", lastName:"Smith")

// husband and wife get married
husband << wife

println wife
