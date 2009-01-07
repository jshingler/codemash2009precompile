import org.jsecurity.SecurityUtils

class BlogController {
	
	def index = { redirect(action:list,params:params) }
	
	// the delete, save and update actions only accept POST requests
	def allowedMethods = [delete:'POST', save:'POST', update:'POST']
	
	def list = {
		if(!params.max) params.max = 10
		[ blogInstanceList: Blog.list( params ) ]
	}
	
	def show = {
		def blogInstance = Blog.get( params.id )
		
		if(!blogInstance) {
			flash.message = "Blog not found with id ${params.id}"
			redirect(action:list)
		}
		else { return [ blogInstance : blogInstance ] }
	}
	
	def delete = {
		def blogInstance = Blog.get( params.id )
		if(blogInstance) {
			blogInstance.delete()
			flash.message = "Blog ${params.id} deleted"
			redirect(action:list)
		}
		else {
			flash.message = "Blog not found with id ${params.id}"
			redirect(action:list)
		}
	}
	
	def edit = {
		def blogInstance = Blog.get( params.id )
		
		if(!blogInstance) {
			flash.message = "Blog not found with id ${params.id}"
			redirect(action:list)
		}
		else {
			return [ blogInstance : blogInstance ]
		}
	}
	
	def update = {
		def blogInstance = Blog.get( params.id )
		if(blogInstance) {
			blogInstance.properties = params
			if(!blogInstance.hasErrors() && blogInstance.save()) {
				flash.message = "Blog ${params.id} updated"
				redirect(action:show,id:blogInstance.id, blog:blogInstance.blogid)
			}
			else {
				render(view:'edit',model:[blogInstance:blogInstance, blog:blogInstance.blogid])
			}
		}
		else {
			flash.message = "Blog not found with id ${params.id}"
			redirect(action:edit,id:params.id,blog:blogInstance.blogid)
		}
	}
	
	def create = {
		def blogInstance = new Blog()
		blogInstance.properties = params
		return ['blogInstance':blogInstance]
	}
	
	def save = {
		def blogInstance = new Blog(params)
		if(!blogInstance.hasErrors() && blogInstance.save()) {
			flash.message = "Blog ${blogInstance.id} created"
			redirect(action:show,id:blogInstance.id)
		}
		else {
			render(view:'create',model:[blogInstance:blogInstance])
		}
	}
	
	def search = {
		def query = params.query
		
		def results
		results = BlogEntry.search(params.query, params)
		
		return [ results: results, query: query, params : params ]
	}
	
	def editByUser = {
		def subject = SecurityUtils.subject
		def user = JsecUser.findByUsername(subject.principal)
		def blog = Blog.findByUser(user)
		params.id = blog.id
		
		redirect(action: edit, id: blog.id, params: params)
	}
}
