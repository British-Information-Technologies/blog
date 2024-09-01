package org.british_information_technologies.michael_blog.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.british_information_technologies.michael_blog.extensions.getStaticHTML

fun Application.configureIndex() {
	routing {
		get("/") {
			val html = this.getStaticHTML("index.html")
			call.respondText(contentType = ContentType.fromFileExtension("html").first()) {
				html ?: "Error"
			}
		}
	}
}