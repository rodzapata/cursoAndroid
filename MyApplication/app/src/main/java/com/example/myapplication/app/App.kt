package com.example.myapplication.app

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun App() {
    val viewModel: MainViewModel = viewModel()

    MainScreen(viewModel)
}

