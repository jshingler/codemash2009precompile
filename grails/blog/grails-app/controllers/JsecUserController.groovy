import org.jsecurity.crypto.hash.Sha1Hash

class JsecUserController {
	
	def index = { redirect(action:list,params:params) }
	
	// the delete, save and update actions only accept POST requests
	def allowedMethods = [delete:'POST', save:'POST', update:'POST']
	
	def list = {
		if(!params.max) params.max = 10
		[ jsecUserInstanceList: JsecUser.list( params ) ]
	}
	
	def show = {
		def jsecUserInstance = JsecUser.get( params.id )
		
		if(!jsecUserInstance) {
			flash.message = "JsecUser not found with id ${params.id}"
			redirect(action:list)
		}
		else { return [ jsecUserInstance : jsecUserInstance ] }
	}
	
	def delete = {
		def jsecUserInstance = JsecUser.get( params.id )
		if(jsecUserInstance) {
			jsecUserInstance.delete()
			flash.message = "JsecUser ${params.id} deleted"
			redirect(action:list)
		}
		else {
			flash.message = "JsecUser not found with id ${params.id}"
			redirect(action:list)
		}
	}
	
	def edit = {
		def jsecUserInstance = JsecUser.get( params.id )
		
		if(!jsecUserInstance) {
			flash.message = "JsecUser not found with id ${params.id}"
			redirect(action:list)
		}
		else {
			return [ jsecUserInstance : jsecUserInstance ]
		}
	}
	
	def update = {
		def jsecUserInstance = JsecUser.get( params.id )
		if(jsecUserInstance) {
			jsecUserInstance.properties = params
			if(!jsecUserInstance.hasErrors() && jsecUserInstance.save()) {
				flash.message = "JsecUser ${params.id} updated"
				redirect(action:show,id:jsecUserInstance.id)
			}
			else {
				render(view:'edit',model:[jsecUserInstance:jsecUserInstance])
			}
		}
		else {
			flash.message = "JsecUser not found with id ${params.id}"
			redirect(action:edit,id:params.id)
		}
	}
	
	def create = {
		def jsecUserInstance = new JsecUser()
		jsecUserInstance.properties = params
		return ['jsecUserInstance':jsecUserInstance]
	}
	
	def save = {
		def jsecUserInstance = new JsecUser(params)
		jsecUserInstance.passwordHash = new Sha1Hash(jsecUserInstance.passwordHash).toHex()
		if(!jsecUserInstance.hasErrors() && jsecUserInstance.save()) {
			// Add Blog
			new Blog(title: "Blog: ${jsecUserInstance.fullName}", 
			blogid: jsecUserInstance.username, user: jsecUserInstance).save()
			
			def userRole = JsecRole.findByName("user")
			new JsecUserRoleRel(user: jsecUserInstance, role: userRole).save()
			
			def basicPermission = JsecPermission.findByType("org.jsecurity.authz.permission.WildcardPermission")
			new JsecUserPermissionRel(
			user: jsecUserInstance,
			permission: basicPermission,
			target: "jsecUser:edit,update:${jsecUserInstance.id}",
			actions: "*").save()
			
			new JsecUserPermissionRel(
			user: jsecUserInstance,
			permission: basicPermission,
			target: "blog:edit,update:${jsecUserInstance.id}",
			actions: "*").save()
			
			new JsecUserPermissionRel(
			user: jsecUserInstance,
			permission: basicPermission,
			target: "blogEntry:edit,update:${jsecUserInstance.id}",
			actions: "*").save()
			
			
			flash.message = "JsecUser ${jsecUserInstance.id} created"
			redirect(action:show,id:jsecUserInstance.id)
		}
		else {
			render(view:'create',model:[jsecUserInstance:jsecUserInstance])
		}
	}
}
