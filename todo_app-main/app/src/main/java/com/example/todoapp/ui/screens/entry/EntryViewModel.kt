package com.example.todoapp.ui.screens.entry

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.model.Task
import com.example.todoapp.data.repository.TodoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class TaskUiState(
    val taskDetailState: TaskDetailState = TaskDetailState(),
    val isEntryValid: Boolean = false
)

data class TaskDetailState(
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val isDone: Boolean = false,
)

class EntryViewModel(
    private val todoRepository: TodoRepository
) : ViewModel() {

    private val _taskUiState = MutableStateFlow(TaskUiState())
    val taskUiState: StateFlow<TaskUiState> = _taskUiState.asStateFlow()

    private fun validateInput(
        uiState: TaskDetailState = taskUiState.value.taskDetailState
    ): Boolean {
        return with(uiState) {
            title.isNotBlank() && description.isNotBlank()
        }
    }

    suspend fun saveTask() {
        if (validateInput()) {
            todoRepository.insertTask(_taskUiState.value.taskDetailState.toTask())
        }
    }

    fun updateUiState(taskDetailState: TaskDetailState) {
        _taskUiState.update { currentState ->
            currentState.copy(
                taskDetailState = taskDetailState,
                isEntryValid = validateInput(taskDetailState)
            )
        }
    }

    /**
     * Extension function to convert [TaskDetailState] to [Task]
     */
    private fun TaskDetailState.toTask(): Task = Task(
        id = id,
        title = title,
        description = description,
        isDone = isDone
    )
}
