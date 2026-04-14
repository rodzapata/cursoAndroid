package com.example.navegacion.ui.screens.user

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.navegacion.data.repository.UserRepository
import com.example.navegacion.domain.model.User

class UserViewModel : ViewModel() {
    private val repository = UserRepository()

    var users by  mutableStateOf<List<User>>(emptyList())
        private set

    fun loadUsers() {
        users = repository.GetUsers()
    }
}