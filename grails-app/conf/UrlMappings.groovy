class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "user", action: "index")
        "/"(controller: "person", action: "index")
        "500"(view:'/error')
	}
}