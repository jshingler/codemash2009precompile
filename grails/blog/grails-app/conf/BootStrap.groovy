import org.jsecurity.crypto.hash.Sha1Hash
import org.jsecurity.authz.permission.WildcardPermission


class BootStrap {

     def init = { servletContext ->
        def basicPermission = new JsecPermission(type: "org.jsecurity.authz.permission.WildcardPermission",
                possibleActions: "*").save()
        
        def adminRole = new JsecRole(name: "administrator").save()
        def userRole = new JsecRole(name: "user").save()
        
        new JsecRolePermissionRel(
                role: adminRole,
                permission: basicPermission,
                target: "*",
                actions: "*").save()
        
        new JsecRolePermissionRel(
                role: userRole,
                permission: basicPermission,
                target: "blog:create,save",
                actions: "*").save()
	    new JsecRolePermissionRel(
                role: userRole,
                permission: basicPermission,
                target: "blogEntry:create,save",
                actions: "*").save()
	    new JsecRolePermissionRel(
                role: userRole,
                permission: basicPermission,
                target: "jsecUser:create,save",
                actions: "*").save()
                
        println "Building Admin User"
        def adminUser = new JsecUser(username: "admin",
             passwordHash: new Sha1Hash("admin").toHex(),
		     fullName: "Admin User",  email: "admin@admin.com").save()
        new JsecUserRoleRel(user: adminUser, role: adminRole).save()
		
        def blog = new Blog(title: "Blog: ${adminUser.fullName}",
	                        blogid: adminUser.username, user: adminUser)
        blog.save()
        
        def dilbert = new JsecUser(
                username: "dilbert",
                passwordHash: new Sha1Hash("password").toHex(),
                fullName: "Scott Adams", 
                email: "dilbert@dilbert.com").save()
        
        new JsecUserPermissionRel(user: dilbert, permission: basicPermission,
            target: "jsecUser:edit,update:${dilbert.id}",actions: "*").save()
				
	    new JsecUserPermissionRel(user: dilbert, permission: basicPermission,
            target: "blog:edit,update:${dilbert.id}", actions: "*").save()
				
        new JsecUserPermissionRel(user: dilbert, permission: basicPermission,
            target: "blogEntry:edit,update:${dilbert.id}", actions: "*").save()
				
        // Add Blog
        blog = new Blog(title: "Blog: ${dilbert.fullName}",
         blogid: dilbert.username, user: dilbert)
        blog.save() 
        
        blog.errors.allErrors.each {
            println it
        }
     }

     def destroy = {
     }
} 