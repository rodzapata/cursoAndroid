package com.example.navegacionunida.feature.orders.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CreateOrderScreen(
    onSave: () -> Unit
) {
    Column {
        Text("Nueva Orden")

        Button(onClick = onSave) {
            Text("Guardar")
        }
    }
}