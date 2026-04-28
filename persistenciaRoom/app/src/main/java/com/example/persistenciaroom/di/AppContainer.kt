package com.example.persistenciaroom.di

import android.content.Context
import com.example.persistenciaroom.data.AppDatabase
import com.example.persistenciaroom.data.repository.TaskRepository
import com.example.persistenciaroom.data.repository.TaskRepositoryImp


interface AppContainer {
    val taskRepository: TaskRepository
}

class DefaultAppContainer(
    private val context: Context,
) : AppContainer {
    override val taskRepository: TaskRepository by lazy {
        TaskRepositoryImp(AppDatabase.getDatabase(context).taskDao())
    }

}