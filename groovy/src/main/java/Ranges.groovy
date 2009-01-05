def numbers = 1..10
assert numbers.size() == 10
numbers.each{ print it }
assert numbers.contains(5)

println()

('a'..'z').each{ print it }

println()

for(i in 'a'..'z') {
	print i
}