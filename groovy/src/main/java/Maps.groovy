def map = ['a':'A', 'b':'B', 'c':'C' ]

println map
println map.getClass().name // java.util.LinkedHashMap

println map['a']
println map.'a'
println map.a
println map.get('a')
println map.getAt('a')

println map.get('d', 'D')
map.e = 'E'
map['f'] = 'F'
map.'g' = 'G'
map.put('h', 'H')

println map

//Print each key/value pair on aseparate line 
map.each { println "Key: ${it.key}, Value: ${it.value}" } 

// Print each key/value pair on aseparate line with index 
map.eachWithIndex { it, i -> println "${i} Key: ${it.key}, Value: ${it.value}" } 


//Print the key set
println "\nKeys:"
map.keySet().each { println it } 

// Print the value set
println "\nValues:"
map.values().each { println it } 

def numbers = new HashMap([1:'one', 2: 'two', 3:'three'])
println numbers.getClass().name

def all = numbers + map 
println all

println "numbers type: ${numbers.getClass().name}, map type: ${map.getClass().name} and all type: ${all.getClass().name} "
println "all: ${all}"
println "map: ${map}"
println "numbers: ${numbers}"


























