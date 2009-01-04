class BlogEntryController {
    
    def index = { redirect(action:list,params:params) }

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
        else { render(view:'list',model: [ blogEntryInstanceList : [blogEntryInstance], print: params.print ? true : false ])  }
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
        return ['blogEntryInstance':blogEntryInstance]
    }

    def save = {
        def blogEntryInstance = new BlogEntry(params)
        if(!blogEntryInstance.hasErrors() && blogEntryInstance.save()) {
            flash.message = "BlogEntry ${blogEntryInstance.id} created"
            redirect(action:show,id:blogEntryInstance.id)
        }
        else {
            render(view:'create',model:[blogEntryInstance:blogEntryInstance])
        }
    }
    
    def preview = {BlogEntry be ->
		log.debug "Preview new entry..."
		render(template: "preview", model: [blogEntryInstance: be])
	}
}
