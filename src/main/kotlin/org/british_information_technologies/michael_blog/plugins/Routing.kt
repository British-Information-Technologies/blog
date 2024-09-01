package org.british_information_technologies.michael_blog.plugins

import io.ktor.http.*
import io.ktor.resources.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.resources.*
import io.ktor.server.resources.Resources
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.webjars.*
import kotlinx.html.body
import kotlinx.html.head
import kotlinx.serialization.Serializable
import org.british_information_technologies.michael_blog.routes.configureStatic

fun Application.configureRouting() {
	install(Webjars) {
		path = "/webjars" //defaults to /webjars
	}

	install(Resources)

	routing {
		configureStatic()
		staticResources("/static", null)

		get("/webjars") {
			call.respondText("<script src='/webjars/jquery/jquery.js'></script>", ContentType.Text.Html)
		}

		get<Articles> { article ->
			// Get all articles ...
			call.respond("List of articles sorted starting from ${article.sort}")
		}
	}
}

@Serializable
@Resource("/articles")
class Articles(val sort: String? = "new")
