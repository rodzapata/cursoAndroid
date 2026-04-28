package com.example.todoapp

import android.app.Application
import com.example.todoapp.data.di.AppContainer
import com.example.todoapp.data.di.DefaultAppContainer

class TodoApplication : Application() {
    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer(this)
    }
}