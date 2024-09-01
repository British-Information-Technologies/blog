package org.british_information_technologies.michael_blog.services

import kotlinx.coroutines.Dispatchers
import org.british_information_technologies.michael_blog.data_types.User
import org.british_information_technologies.michael_blog.schemas.Users
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

class UserService(database: Database) {

	init {
		transaction(database) {
			SchemaUtils.create(Users)
		}
	}

	suspend fun create(user: User): Int = dbQuery {
		Users.insert {
			it[Users.name] = user.name
			it[Users.age] = user.age
		}[Users.id]
	}

	suspend fun read(id: Int): User? {
		return dbQuery {
			Users.selectAll()
				.where { Users.id eq id }
				.map { User(it[Users.name], it[Users.age]) }
				.singleOrNull()
		}
	}

	suspend fun update(id: Int, user: User) {
		dbQuery {
			Users.update({ Users.id eq id }) {
				it[Users.name] = user.name
				it[Users.age] = user.age
			}
		}
	}

	suspend fun delete(id: Int) {
		dbQuery {
			Users.deleteWhere { Users.id.eq(id) }
		}
	}

	private suspend fun <T> dbQuery(block: suspend () -> T): T =
		newSuspendedTransaction(Dispatchers.IO) { block() }
}