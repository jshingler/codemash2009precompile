def quote = "Double Quote"
println "${quote} is a ${quote.class.name}"

def single = 'Single Quote'
println "${single} is a ${single.class.name}"

def slashy = /Slashy Quote/
println "${slashy} is a ${slashy.class.name}"

def gstring = "GString ${new Date()}"
println "${gstring} is a ${gstring.class.name}"

def multiline = """select * from table
where name=value"""

println "${multiline} is a ${multiline.class.name}"

