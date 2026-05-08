package com.example.navegacion.ui.screens.user

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun UserScreen(
    viewModel: UserViewModel = viewModel(),
    padding: PaddingValues

) {

   // val state by viewModel.state.collectAsState()
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.loadUsers()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(16.dp)
    ) {

        when {
            state.isLoading -> {
                Text("Cargando...")
            }

            state.error != null -> {
                Text("Error: ${state.error}")
            }

            else -> {
                state.users.forEach {
                    Text(text = it.name)
                }
            }
        }
    }
}