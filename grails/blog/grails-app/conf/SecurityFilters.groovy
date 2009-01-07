class SecurityFilters {
    def filters = {
		
		auth(controller: "(blog|blogEntry)", action: "(create|save)") {
            before = {
                // This just means that the user must be authenticated. He does 
				// not need any particular role or permission.
                accessControl { true } 
			} 
		}
		
        jsecUser(controller: "jsecUser", action: "(edit|update|delete)") {
            before = {
                accessControl {
				    def userId = 0
                    if (params.id) {
                        userId = JsecUser.get(params.id).id
                    }
					println "SecurityFilter: jsecUser:${actionName ?: 'list'}:${userId}"
					role("administrator") || permission("jsecUser:${actionName ?: 'list'}:${userId}")
                }
            }
        }
		
		blog(controller: "(blog|blogEntry)", action: "(edit|update|delete)") {
            before = {
                accessControl {
				    def userId = 0
				    def blogId = 0
					def blog
                    if (params.id) {
					    blog = Blog.get(params.id)
                        userId = blog.user.id
                    }
					println "SecurityFilter: blog:${actionName ?: 'list'}:${userId}"
					role("administrator") || permission("blog:${actionName ?: 'list'}:${userId}")
                }
            }
        }
    }
}
