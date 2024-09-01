package org.british_information_technologies.michael_blog.extensions

import java.util.Properties

fun Any.getProperties(path: String): Properties = Properties().apply {
	load( this::class.java.getResourceAsStream(path))
}

/**
 * Gets the contents of a html file in resources directory in static.
 *
 * @return [String] The contents of the html file.
 */
fun Any.getStaticHTML(path: String): String? {
	return this::class.java.getResourceAsStream("/static/$path")?.readAllBytes()?.decodeToString()
}