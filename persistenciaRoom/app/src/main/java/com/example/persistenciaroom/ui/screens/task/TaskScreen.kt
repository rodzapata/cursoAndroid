package com.example.persistenciaroom.ui.screens.task

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.persistenciaroom.data.TaskEntity

@Composable
fun TaskScreen(
    state: TaskViewModel.State,
    onClearClick: () -> Unit,
    onAddClick: (String) -> Unit,
    onToggleTask: (TaskEntity) -> Unit
) {
    Scaffold(
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 48.dp),
                contentAlignment = Alignment.Center

            ) {
                Button(
                    onClick = onClearClick

                ) {

                }
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            // Tu UI aquí
        }
    }

}