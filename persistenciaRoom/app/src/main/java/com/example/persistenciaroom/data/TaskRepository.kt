package com.example.persistenciaroom.data

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

interface  taskRepository{
    fun observeTasks(): Flow<List<TaskEntity>>

    suspend fun insertTask(task: TaskEntity)

    suspend fun updateTask(task: TaskEntity)

    suspend fun upsert(task: TaskEntity)

    suspend fun clearAllTask()

}