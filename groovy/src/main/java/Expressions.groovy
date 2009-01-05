// Matching Operator

assert "abc" ==~ 'abc' 
assert "abc" ==~ /abc/ 
assert !("abcabc" ==~ /abc/)  // Fails – not an exact match 
assert "abc" ==~ /^a.c/   // Starts with a, 1 char, ends with c 
assert "abc" ==~ /^a../   // Starts with a, 2 chars 
assert "abc" ==~ /.*c$/   // One or more chars end with c 
assert "abc" ==~ ".*c\$"  // Slashy string is better

// Find Operator
def matcher = 'Groovy is groovy' =~ /(G|g)roovy/ 
print "Size of matcher is ${matcher.size()} " 
println "with elements ${matcher[0]} and ${matcher[1]}."

// Pattern Operator
def quote = """Now is the time 
for all good men (and women) 
to come to the aid 
of their country""" 

def pattern = ~/(\w+en)/ 
matcher = pattern.matcher(quote) 
println "Matches = ${matcher.getCount()}"
for(i in matcher.iterator()) {
	println i
}

