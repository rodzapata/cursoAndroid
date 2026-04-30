package com.example.persistenciaroom.ui.screens.task

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.persistenciaroom.data.AppDatabase
import com.example.persistenciaroom.data.TaskDao
import com.example.persistenciaroom.data.TaskEntity
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val database: AppDatabase = AppDatabase.getDatabase(application)
    private val taskDao: TaskDao = database.taskDao()

    val state: StateFlow<State> =
        taskDao
            .observeTasks()
            .map { tasks ->
                State(tasks = tasks)
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.Lazily,
                initialValue = State(emptyList())
            )

    fun addTask(title: String) {
        if (title.isBlank()) return
        viewModelScope.launch {
            taskDao.insertTask(
                TaskEntity(title = title.trim())
            )
        }
    }

    fun toggleTask(task: TaskEntity) {
        viewModelScope.launch {
            taskDao.updateTask(
                task.copy(isDone = !task.isDone)
            )
        }
    }

    fun clearAll() {
        viewModelScope.launch {
            taskDao.clearAllTask()
        }
    }

    data class State(
        val tasks: List<TaskEntity> = emptyList(),
        val newTaskTitle: String = ""
    )

}