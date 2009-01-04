class BlogEntry {
	String title
	String body
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = [ Blog ]
	Blog blog
	
	static constraints = {
		title(blank: false, maxSize: 128)
		body(blank: false, maxSize: 10000)
		dateCreated()
		lastUpdated(nullable: true)
	}
	String toString () {
		return "BlogEntry ${id} = ${title}"
	}
}
