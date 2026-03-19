package com.example.device

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.device.ui.theme.DeviceTheme
import androidx.compose.runtime.*
import androidx.compose.ui.text.style.TextAlign
import com.example.device.ui.theme.Typography

@Composable
fun MainView(name: String, modifier: Modifier = Modifier, devices: List<Device>) {

    Column {
        Text(
            text = "Comprar",
            modifier = modifier
                .padding(20.dp)
                .fillMaxWidth(),
            style = Typography.displayMedium,
            textAlign = TextAlign.Center
        )

        LazyColumn() {
            items(devices.size) { index ->
                DeviceItemView(device = devices[index])
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainPreview() {
    DeviceTheme {
        MainView(
            "Android", Modifier.padding(top = 24.dp), devices = listOf(
                Device(
                    id = 1,
                    name = "Nexus",
                    data = Specs(color = "Red", capacity = "20 GB")
                ),
                Device(
                    id = 2,
                    name = "Motorola",
                    data = null
                )
            )
        )
    }
}