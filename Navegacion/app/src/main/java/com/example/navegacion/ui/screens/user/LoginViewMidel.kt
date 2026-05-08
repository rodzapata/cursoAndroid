package com.example.navegacion.ui.screens.user

data class UiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
)

sealed interface LoginEvent{

    data class OnEmailChange(
        val value: String
    ): LoginEvent

    data class OnPasswordChange(
        val value: String
    ): LoginEvent

    data object OnLoginClick: LoginEvent
}
