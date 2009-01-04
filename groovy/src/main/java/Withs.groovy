def list = [1,2,3,4,5]

list.add(6)
list.add(7)

list.with {
	add(8)
	add(9)
}

list.identity {
	add(10)
	add(11)
}

println list