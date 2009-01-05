def numbers = [1,2,3,4,5,6,7,8,9,10]

def odds = numbers.findAll { it % 2}
println odds

println numbers.join(' ')