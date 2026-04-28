package com.example.todoapp.data.di

import android.content.Context
import com.example.todoapp.data.database.TodoDatabase
import com.example.todoapp.data.repository.TodoRepository
import com.example.todoapp.data.repository.TodoRepositoryImp

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val todoRepository: TodoRepository
}

/**
 * [AppContainer] implementation that provides instance of [TodoRepositoryImp]
 */
class DefaultAppContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [TodoRepository]
     */
    override val todoRepository: TodoRepository by lazy {
        TodoRepositoryImp(TodoDatabase.getDatabase(context).taskDao())
    }
}