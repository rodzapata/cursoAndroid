package com.example.navegacionunida.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun inicio(navSegundaPantalla: (String) -> Unit) {

    //var valor by remember { mutableStateOf("") }
    var valor by rememberSaveable { mutableStateOf("")}


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "inicio de pantalla"
        )
        OutlinedTextField(
            value = valor,
            onValueChange = { valor = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)

        )
        Button(onClick = { navSegundaPantalla(valor) }
        ) {
            Text(
                text = "enviar a segunda pantalla"
            )
        }
    }
}