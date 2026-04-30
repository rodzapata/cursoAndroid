package com.example.navegacionunida.feature.orders.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun OrderDetailScreen(
    id: String,
    onBack: () -> Unit
) {
    Column {
        Text("Detalle de Orden: $id")

        Button(onClick = onBack) {
            Text("Volver")
        }
    }
}