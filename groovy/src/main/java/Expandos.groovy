def user = new Expando() 
 
 user.firstName = 'Christopher' 
 user.lastName = 'Judd' 
 
 user.greeting = { greeting -> 
   "${greeting} ${firstName} ${lastName}" 
 } 
 
println user.greeting("Hello")