package com.example.navegacionunida.feature.orders.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun OrdersScreen(
    onDetail: (String) -> Unit,
    onCreate: () -> Unit
) {
    Column {
        Button(onClick = { onDetail("1") }) {
            Text("Ver Orden #1")
        }

        Button(onClick = onCreate) {
            Text("Crear Orden")
        }
    }
}