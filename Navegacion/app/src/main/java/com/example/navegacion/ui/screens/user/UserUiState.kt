package com.example.navegacion.ui.screens.user

import com.example.navegacion.domain.model.User

data class UserUiState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val error: String? = null
)