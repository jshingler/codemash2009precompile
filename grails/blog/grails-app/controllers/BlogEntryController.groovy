import org.jsecurity.SecurityUtils

class BlogEntryController {
	
	def index = { redirect(action:list,params:params)
	}
	
	// the delete, save and update actions only accept POST requests
	def allowedMethods = [delete:'POST', save:'POST', update:'POST']
	
	def list = {
		if(!params.max) params.max = 10
		[ blogEntryInstanceList: BlogEntry.list( params ) ]
	}
	
	def show = {
		def blogEntryInstance = BlogEntry.get( params.id )
		
		if(!blogEntryInstance) {
			flash.message = "BlogEntry not found with id ${params.id}"
			redirect(action:list)
		}
		else { render(view:'list',model: [ blogEntryInstanceList : [blogEntryInstance], print: params.print ? true : false ])
		}
		//        else { return [ blogEntryInstance : blogEntryInstance ] }
	}
	
	def delete = {
		def blogEntryInstance = BlogEntry.get( params.id )
		if(blogEntryInstance) {
			blogEntryInstance.delete()
			flash.message = "BlogEntry ${params.id} deleted"
			redirect(action:list)
		}
		else {
			flash.message = "BlogEntry not found with id ${params.id}"
			redirect(action:list)
		}
	}
	
	def edit = {
		def blogEntryInstance = BlogEntry.get( params.id )
		
		if(!blogEntryInstance) {
			flash.message = "BlogEntry not found with id ${params.id}"
			redirect(action:list)
		}
		else {
			return [ blogEntryInstance : blogEntryInstance ]
		}
	}
	
	def update = {
		def blogEntryInstance = BlogEntry.get( params.id )
		if(blogEntryInstance) {
			blogEntryInstance.properties = params
			if(!blogEntryInstance.hasErrors() && blogEntryInstance.save()) {
				flash.message = "BlogEntry ${params.id} updated"
				redirect(action:show,id:blogEntryInstance.id)
			}
			else {
				render(view:'edit',model:[blogEntryInstance:blogEntryInstance])
			}
		}
		else {
			flash.message = "BlogEntry not found with id ${params.id}"
			redirect(action:edit,id:params.id)
		}
	}
	
	def create = {
		def blogEntryInstance = new BlogEntry()
		blogEntryInstance.properties = params
		blogEntryInstance.title = "Title"
		blogEntryInstance.body = "<p>\n\n</p>"
		render(view:'edit',model: ['blogEntryInstance':blogEntryInstance])
	}
	
	def save = {
		def blogEntryInstance = new BlogEntry(params)
		
		if (blogEntryInstance.hasErrors()) {
			render(view:'create',model:[blogEntryInstance:blogEntryInstance])
			return
		} else {
			def subject = SecurityUtils.subject
			def user = JsecUser.findByUsername(subject.principal)
			def blog = Blog.findByUser(user)
			
			log.debug "Adding new entry to blog ${blog?.title}"
			blog?.addToBlogEntries(blogEntryInstance)?.save()
			blogEntryInstance.save()
					
			flash.message = "BlogEntry ${blogEntryInstance.id} created"
			redirect(action:show,id:blogEntryInstance.id)
			
		}
		
	}
	
	def preview = {BlogEntry be ->
		log.debug "Preview new entry..."
		render(template: "preview", model: [blogEntryInstance: be])
	}
	
	def displayEntry = {
		
		log.info "Ok.. We're goes to display selected entries for ${params.blog}"
		
		def baseUri = request.scheme + "://" + request.serverName + ":" + request.serverPort +
		grailsAttributes.getApplicationUri(request)
		
		def blogId = params.blog
		
		int year = params.year ? Integer.parseInt(params.year) : 0
		int month = params.month ? Integer.parseInt(params.month) - 1 : 0
		int day = params.day ? Integer.parseInt(params.day) : 1
		
		log.info "Creating date query using $params.year $params.month $params.day"
		def cal = Calendar.getInstance()
		cal.set(year, month, day, 0, 0, 0)
		
		def blogStartDate = cal.time
		if (params.day) {
			cal.add(Calendar.HOUR_OF_DAY, 24)
		} else if (params.month) {
			cal.add(Calendar.MONTH, 1)
		} else if (params.year) {
			cal.add(Calendar.YEAR, 1)
		}
		def blogEndDate = cal.time
		
		log.info "Searching blog: ${blogId} between $blogStartDate and $blogEndDate"
		
		def blog = Blog.findByBlogid(blogId)
		if (blog) {
			log.info "Blog name is ${blog.title}"
			
			def entries = BlogEntry.findAllByBlogAndDateCreatedBetween(blog, blogStartDate, blogEndDate, [sort: 'dateCreated', order: 'desc'])
			log.info "Found some entries... for $blogId then we're ${entries.size()}"
			if (params.id) {
				// if we have an id, match that entry..
				def filtered = entries.findAll { it.title.encodeAsNiceTitle() == params.id
				}
				if (filtered.size())
				entries = filtered
			}
			render(view:'list',model: [ blogEntryInstanceList : entries, 'baseUri': baseUri, print: params.print ? true : false]) 
		} else {
			response.sendError(response.SC_NOT_FOUND);
		}
	}
	
	def homePage = {
		def baseUri = request.scheme + "://" + 
		request.serverName + ":" + request.serverPort +
		grailsAttributes.getApplicationUri(request)
		
		def blogId = params.blog
		def blog = Blog.findByBlogid(blogId)
		if (blog) {
			// display most recent 5 entries
			def entries = BlogEntry.findAllByBlog(blog, [sort: 'dateCreated', order: 'desc', max: 5])
			render(view: 'displayEntry', 
			model:  [blogObj: blog, entries: entries, 
			print: params.print ? true : false, baseUri: baseUri ])
		} else {
			response.sendError(response.SC_NOT_FOUND);
		}
	}
	
	def userHomePage = {
		def subject = SecurityUtils.subject
		def user = JsecUser.findByUsername(subject.principal)
		def blog = Blog.findByUser(user)
		params.blog = blog.blogid
		
		redirect(action: homePage, params: params)
	}
}
