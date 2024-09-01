package org.british_information_technologies.michael_blog.plugins

import io.ktor.server.application.*
import io.ktor.server.plugins.openapi.*
import io.ktor.server.routing.*

fun Application.configureOpenAPI() {
	routing {
		openAPI(path = "openapi")
	}
}
