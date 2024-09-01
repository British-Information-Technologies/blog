package org.british_information_technologies.michael_blog.data_types

import kotlinx.serialization.Serializable

@Serializable
data class City(val name: String, val population: Int)