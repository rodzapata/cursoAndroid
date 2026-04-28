package com.example.persistenciaroom.data.repository

import com.example.persistenciaroom.data.TaskDao
import com.example.persistenciaroom.data.TaskEntity
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImp(private val taskDao: TaskDao) : TaskRepository {
    override fun observeTasks(): Flow<List<TaskEntity>> = taskDao.observeTasks()


    override suspend fun insertTask(task: TaskEntity) = taskDao.insertTask(task)

    override suspend fun updateTask(task: TaskEntity) = taskDao.updateTask(task)

    override suspend fun upsert(task: TaskEntity) = taskDao.upsert(task)

    override suspend fun clearAllTask() = taskDao.clearAllTask()

}