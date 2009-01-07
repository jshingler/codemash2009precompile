class UrlMappings {
    static mappings = {
      "/$controller/$action?/$id?"{
	      constraints {
			 // apply constraints here
		  }
	  }
      
      "/$blog/$year/$month?/$day?/$id?" {
          controller = "blogEntry"
          action = "displayEntry"
          constraints {
              year(matches: /\d{4}/)
              month(matches: /\d{2}/)
              day(matches: /\d{2}/)
          }
    }
    
    "/$blog/" {
          controller = "blogEntry"
          action = "homePage"
    }
      
	  "500"(view:'/error')
	}
}
