package org.british_information_technologies.michael_blog.routes

import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import org.british_information_technologies.michael_blog.plugins.respondCss
import org.british_information_technologies.michael_blog.styles.MainCssStyle

fun Route.configureStatic() {
	staticResources("/static", "/static")


}