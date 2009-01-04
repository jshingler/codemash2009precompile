def passwordtize(text) {
	def password = ''
	text.each {password += '*'}
	password
}

println "password for chris is ${passwordtize('chris')}"
println "password for fred is ${passwordtize('fred')}"