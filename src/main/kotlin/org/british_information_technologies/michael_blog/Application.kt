package org.british_information_technologies.michael_blog

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.british_information_technologies.michael_blog.plugins.*
import org.british_information_technologies.michael_blog.routes.configureIndex
import org.british_information_technologies.michael_blog.routes.configureStatusPages


fun main() {
	embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
		.start(wait = true)
}

fun Application.module() {
	configureDatabases()
	configureSerialization()
//	configureWebSockets()

	configureTemplating()

	configureIndex()

//	configureOpenAPI()
//	configureSecurity()
	configureStatusPages()
	configureRouting()
}
