package com.example.myapplication.app

import androidx.lifecycle.ViewModel
import com.example.myapplication.core.navigation.NavState
import com.example.myapplication.core.navigation.Screen
import com.example.myapplication.core.navigation.Tab
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {

    private val _state = MutableStateFlow(NavState())
    val state = _state.asStateFlow()

    fun switchTab(tab: Tab) {
        _state.update { it.copy(currentTab = tab) }
    }

    fun navigate(screen: Screen) {
        _state.update { state ->
            val currentStack = state.stacks[state.currentTab]!!

            state.copy(
                stacks = state.stacks + (
                        state.currentTab to (currentStack + screen)
                        )
            )
        }
    }

    fun goBack() {
        _state.update { state ->
            val currentStack = state.stacks[state.currentTab]!!

            if (currentStack.size > 1) {
                state.copy(
                    stacks = state.stacks + (
                            state.currentTab to currentStack.dropLast(1)
                            )
                )
            } else state
        }
    }
}