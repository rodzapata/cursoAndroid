package com.example.curso

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
/*
@Composable
fun myOutLineTextField(modifier: Modifier = Modifier) {

    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.padding(50.dp)
    )
    {

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text(text = "nombre del cliente") }

        )

        OutlinedTextField(
            value = apellido,
            onValueChange = { apellido = it },
            label = { Text(text = "apellido") }
        )
    }
}
*/
