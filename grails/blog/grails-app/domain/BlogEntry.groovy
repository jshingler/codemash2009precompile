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
	
	static searchable = {
		only = ["title", "body", "dateCreated", "blogs"] 
		
		blog(component: true)
	}
	
	def indexedFields() {
		
		def fields = [:]
		// strip html before storing in index
		fields.title = title.replaceAll("\\<.*?\\>","")
		fields.body = body.replaceAll("\\<.*?\\>","")
		
		return fields
		
	}
	
	public String toPermalink() {
		def sdf = new java.text.SimpleDateFormat("yyyy/MM/dd")
		return "/${blog?.blogid}/${sdf.format(dateCreated)}/${title.encodeAsNiceTitle()}.html"
	}
	
	String toString () {
		return "BlogEntry ${id} = ${title}"
	}
}
