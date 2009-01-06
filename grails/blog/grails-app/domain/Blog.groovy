class Blog {
	String blogid
	String title
	String byline
	Date dateCreated
	Date lastUpdated
	
	static hasMany = [ blogEntries : BlogEntry]
	
	static constraints = {
		title(blank: false, size: 1..128)
		byline(nullable: true)
		blogid(blank: false)
		dateCreated()
		lastUpdated(nullable: true)
	}
	
	static searchable = {
        only = ["blogid", "title", "byline"] 
        
        root : false
    }
	
	String toString () {
		return "Blog ${id} = ${title}"
	}
}
