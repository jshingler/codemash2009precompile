class EntriesTagLib{

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
	
}
