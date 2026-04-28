package com.example.persistenciaroom.data.repository

import com.example.persistenciaroom.data.TaskEntity
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun observeTasks(): Flow<List<TaskEntity>>

    suspend fun insertTask(task: TaskEntity)

    suspend fun updateTask(task: TaskEntity)

    suspend fun upsert(task: TaskEntity)

    suspend fun clearAllTask()

}