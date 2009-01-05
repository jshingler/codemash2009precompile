def closure = { println "hello!" }
closure() //prints "hello!"

def printNames = {name -> println "Hello ${name} !" }
printNames('Chris') //prints "Hello Chris"

closure = {println "Hello ${it}!" }
closure('Jim') //prints "Hello Jim"

def list = []

10.times(printNames)

10.upto(20) { println it}
