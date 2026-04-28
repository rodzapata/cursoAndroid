package com.example.todoapp.data.repository

import com.example.todoapp.data.model.Task
import kotlinx.coroutines.flow.Flow

/**
 * Repository that provides insert, update, delete, and retrieve of [Task] from a given data source.
 */
interface TodoRepository {
    fun getAllTasks(): Flow<List<Task>>

    fun getTaskById(id: Int): Flow<Task>

    suspend fun insertTask(task: Task)

    suspend fun updateTask(task: Task)

    suspend fun deleteTask(task: Task)
}