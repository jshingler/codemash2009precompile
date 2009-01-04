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
                redirect(action:show,id:blogInstance.id)
            }
            else {
                render(view:'edit',model:[blogInstance:blogInstance])
            }
        }
        else {
            flash.message = "Blog not found with id ${params.id}"
            redirect(action:edit,id:params.id)
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
}
