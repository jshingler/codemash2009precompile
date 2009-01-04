class Blog {
	String blogid
	String title
	String byline
	Date dateCreated
	Date lastUpdated
	
	static hasMany = [ blogEntries : BlogEntry]
	
	static constraints = {
		title(blank: false, size: 1..128)
		byline(blank: false, size: 1..128)
		blogid(blank: false)
		dateCreated()
		lastUpdated(nullable: true)
	}
	
	String toString () {
		return "Blog ${id} = ${title}"
	}
}