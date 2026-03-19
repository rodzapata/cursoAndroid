package com.example.device

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.device.ui.theme.DeviceTheme
import androidx.compose.runtime.*

@Composable
fun FormView(modifier: Modifier= Modifier){
    var name by remember { mutableStateOf("") }

    Column {

    TextField(
            value = name,
            onValueChange = { nuevoName ->
                name = nuevoName
            },
            placeholder = {
                Text(text = "nombre")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )
    }
}
/*
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewForm() {
    DeviceTheme {
        FormView( Modifier.padding(top = 24.dp))
    }
}
*/
