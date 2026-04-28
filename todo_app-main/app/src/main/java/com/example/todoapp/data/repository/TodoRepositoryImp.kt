package com.example.todoapp.data.repository

import com.example.todoapp.data.dao.TaskDao
import com.example.todoapp.data.model.Task
import kotlinx.coroutines.flow.Flow

class TodoRepositoryImp(private val taskDao: TaskDao) : TodoRepository {
    override fun getAllTasks(): Flow<List<Task>> = taskDao.getAllTasks()

    override fun getTaskById(id: Int): Flow<Task> = taskDao.getTaskById(id)

    override suspend fun insertTask(task: Task) = taskDao.insertTask(task)

    override suspend fun updateTask(task: Task) = taskDao.updateTask(task)

    override suspend fun deleteTask(task: Task) = taskDao.deleteTask(task)
}