package com.example.navegacionunida.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun SegundaPantalla(
    id: String,
    navInicio: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "segunda pantalla"
        )
        Text(
            text = id
        )
        Button(
            onClick = { navInicio() }
        ) {
            Text(
                text = "regreso al inicio"
            )
        }
    }
}
