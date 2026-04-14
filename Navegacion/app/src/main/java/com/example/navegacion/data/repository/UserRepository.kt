package com.example.navegacion.data.repository
import com.example.navegacion.domain.model.User

class UserRepository {
    fun GetUsers(): List<User> {
        return listOf(
            User(id = 1, name = "Rodney"),
            User(id = 2, name = "cecilia"),
            User(id = 3, name = "juan miguel"),
            User(id = 3, name = "samuel"),

        )
    }
}