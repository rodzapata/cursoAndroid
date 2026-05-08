package com.example.navegacion.ui.screens.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navegacion.data.repository.UserRepository
import com.example.navegacion.data.repository.UserRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel(
    private val repository: UserRepository = UserRepositoryImpl()
) : ViewModel() {

    private val _state = MutableStateFlow(UserUiState())
    val state: StateFlow<UserUiState> = _state

    fun loadUsers() {
        viewModelScope.launch {

            _state.value = _state.value.copy(isLoading = true)

            try {
                val users = repository.getUsers()

                _state.value = _state.value.copy(
                    isLoading = false,
                    users = users
                )

            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }
}