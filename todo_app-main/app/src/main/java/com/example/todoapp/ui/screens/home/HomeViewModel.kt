package com.example.todoapp.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.model.Task
import com.example.todoapp.data.repository.TodoRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class HomeUiState(val tasksList: List<Task> = listOf())

class HomeViewModel(
    private val todoRepository: TodoRepository
) : ViewModel() {

    val homeUiState: StateFlow<HomeUiState> =
        todoRepository.getAllTasks().map { HomeUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = HomeUiState()
            )

    fun updateTask(task: Task) {
        viewModelScope.launch {
            todoRepository.updateTask(task)
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            todoRepository.deleteTask(task)
        }
    }
}