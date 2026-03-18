package com.example.device

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.device.ui.theme.DeviceTheme
import com.example.device.ui.theme.Typography

@Composable
fun DeviceView(device: Device) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector = Icons.Default.Phone, contentDescription = null)
        Column {
            Text(text = device.name, style = Typography.headlineMedium)
            Text(text = device.data?.color ?: "-", style = Typography.bodyMedium)
            Text(text = device.data?.capacity ?: "-", style = Typography.bodyMedium)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DeviceItemPreview() {
    DeviceTheme() {
        DeviceView(
            device = Device(
                id = 1,
                name = "Nexus",
                data = Specs(color = "Red", capacity = "20 GB")
            )
        )
    }
}