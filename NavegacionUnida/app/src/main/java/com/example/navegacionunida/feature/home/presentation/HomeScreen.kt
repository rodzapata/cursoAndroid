package com.example.navegacionunida.feature.home.presentation

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen() {
    Button(onClick = {}) {
        Text("Ir a Órdenes")
    }
}


/*
@Composable
fun HomeScreen(onGoOrders: () -> Unit) {
    Button(onClick = onGoOrders) {
        Text("Ir a Órdenes")
    }
}
 */