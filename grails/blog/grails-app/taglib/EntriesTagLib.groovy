import org.jsecurity.SecurityUtils

class EntriesTagLib{
	def niceDate = { attrs ->
		def date = attrs.date ?: new Date()
		def sdf = new java.text.SimpleDateFormat("EEE, d MMM yyyy HH:mm")
		out << sdf.format(date)
	}
	
	def blogDateRolodex = { attrs ->
		def date = attrs.date ?: new Date()
		
		def sdf = new java.text.SimpleDateFormat("dd")
		def smf = new java.text.SimpleDateFormat("MMM")
		def syf = new java.text.SimpleDateFormat("yyyy")
		
		out << '<div class="dateblock">'
		out << '<div class="month"> '
		out << smf.format(date).toUpperCase()
		out << '</div><div class="day">'
		out << sdf.format(date).toUpperCase()
		out << '</div><div class="year">'
		out << syf.format(date).toUpperCase()
		out << "</div></div>"
	}
	
	def blogTitle = { attrs ->
		def blogId = attrs.blogid
		if (blogId) {
			Blog blog = Blog.findByBlogid(blogId)
			if (blog)
			out << blog.title
			else
			out << "Grail's Blog"
		} else {
			out << "Grail's Blog"
		}
		
	}
	
	def blogByline = { attrs ->
		def blogId = attrs.blogid
		if (blogId) {
			Blog blog = Blog.findByBlogid(blogId)
			if (blog)
			out << blog.byline
			else
			out << "Blog byline"
		} else {
			out << "Blog byline"
		}
	}
	
	def userFullName = { attr ->
		def subject = SecurityUtils.getSubject()
		out << JsecUser.findByUsername(subject?.principal)?.fullName        
	}
	
}
