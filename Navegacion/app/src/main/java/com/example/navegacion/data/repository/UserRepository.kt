package com.example.navegacion.data.repository
import com.example.navegacion.domain.model.User

interface UserRepository {
    suspend fun getUsers(): List<User>
}

