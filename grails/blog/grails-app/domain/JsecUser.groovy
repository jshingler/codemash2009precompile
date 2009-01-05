class JsecUser {
	String username
	String passwordHash
	String fullName
	String email
	
	static constraints = {
		username(nullable: false, blank: false)
		fullName (blank: false)
		email (blank: false, email: true)
	}
	
	String toString() {
		return "User ${id} - ${fullName}"
	}
	
}
