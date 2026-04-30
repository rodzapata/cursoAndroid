package com.example.navegacionunida.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier

fun App(){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        App(
            name = "Android",
            modifier = Modifier.padding(innerPadding)
        )
    }

}
