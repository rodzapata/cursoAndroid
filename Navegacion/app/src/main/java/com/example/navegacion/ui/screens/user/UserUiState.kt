package com.example.navegacion.ui.screens.user

import com.example.navegacion.domain.model.User

sealed class UserUiState {
    object Loading : UserUiState()
    data class Success(val users: List<User>) : UserUiState()
    data class Error(val message: String) : UserUiState()
}