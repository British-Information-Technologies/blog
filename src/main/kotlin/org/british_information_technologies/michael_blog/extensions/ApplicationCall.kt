package org.british_information_technologies.michael_blog.extensions

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import kotlinx.css.CSSBuilder

suspend inline fun ApplicationCall.respondCss(builder: CSSBuilder.() -> Unit) {
	val css = CSSBuilder().apply(builder).toString()
	this.respondText(css, ContentType.Text.CSS)
}