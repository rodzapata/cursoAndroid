package com.example.device

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.device.ui.theme.DeviceTheme

@Composable
fun MainView(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Comprar",
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainPreview() {
    DeviceTheme {
        MainView("Android", Modifier.padding(top = 24.dp))
    }
}