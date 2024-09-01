package org.british_information_technologies.michael_blog.styles

import kotlinx.css.*
import org.british_information_technologies.michael_blog.extensions.main

fun CSSBuilder.MainCssStyle() {

	val full_width = LinearDimension("100%")

	html {

		fontFamily = "arial"

		width = full_width
		height = full_width

		margin = "0"
		padding = "0"
	}

	body {
		width = full_width
		height = full_width

		margin = "0"
		padding = "0"
	}
}