package com.example.navegacionunida.app

import androidx.lifecycle.ViewModel
import com.example.navegacionunida.core.navigation.NavState
import com.example.navegacionunida.core.navigation.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {

    private val _state = MutableStateFlow(NavState())
    val state = _state.asStateFlow()

    fun navigate(screen: Screen) {
        _state.update {
            it.copy(backStack = it.backStack + screen)
        }
    }

    fun goBack() {
        _state.update {
            if (it.backStack.size > 1) {
                it.copy(backStack = it.backStack.dropLast(1))
            } else it
        }
    }
}