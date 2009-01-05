class FeedController {

    def index = { redirect(action:list,params:params) }
	
	def list = {
		render(feedType:"rss", feedVersion:"2.0"){
			title="CM Blogs"
			link="http://localhost:8080/blog/feed"
			description="Demo Blog Feed from CodeMash 2009"
			def blogs = BlogEntry.list([max: 5, sort: "dateCreated", order: "desc"])
			blogs.each{blogEntry ->
				entry(blogEntry.title) {
					link="http://localhost:8080/blog/blogEntry/show/${blogEntry.id}"
					blogEntry.body
				}
			}
		}
	}

}
