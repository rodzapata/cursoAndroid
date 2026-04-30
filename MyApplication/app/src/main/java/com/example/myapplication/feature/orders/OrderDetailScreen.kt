package com.example.myapplication.feature.orders

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OrderDetailScreen(
    orderId: Int
) {

    // Simulación de datos (luego lo conectas a API)
    val order = remember {
        mapOf(
            "id" to orderId,
            "cliente" to "Empresa ABC",
            "equipo" to "Aire Acondicionado",
            "estado" to "Pendiente"
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("Detalle de Orden #${order["id"]}", style = MaterialTheme.typography.titleLarge)

        Spacer(Modifier.height(16.dp))

        Card {
            Column(Modifier.padding(16.dp)) {

                Text("Cliente: ${order["cliente"]}")
                Text("Equipo: ${order["equipo"]}")
                Text("Estado: ${order["estado"]}")
            }
        }

        Spacer(Modifier.height(24.dp))

        // Acciones
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {

            Button(onClick = { /* cambiar estado */ }) {
                Text("Marcar como completado")
            }

            OutlinedButton(onClick = { /* editar */ }) {
                Text("Editar")
            }
        }
    }
}