package org.british_information_technologies.michael_blog.schemas

import org.jetbrains.exposed.sql.Table

object Users : Table() {
	val id = integer("id").autoIncrement()
	val name = varchar("name", length = 50)
	val age = integer("age")

	override val primaryKey = PrimaryKey(id)
}