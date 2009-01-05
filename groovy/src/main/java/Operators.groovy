// Spread Operator

def strings = ['chris', 'jim', 'joseph']

println strings*.getAt(0)

// Elvis Operator

def value = null
println value == null ? "unknown" : value // Java ternary
println value ?: "unknown" // Elvis Operator
		
value = "cool"
println value ?: "unknown" // Elvis Operator
		
// Safe Navigation/Dereference Operator

def string = null
println "String length is ${string?.size()}"