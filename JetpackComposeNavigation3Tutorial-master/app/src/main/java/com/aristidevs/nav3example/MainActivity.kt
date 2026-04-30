package com.aristidevs.nav3example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aristidevs.nav3example.advance_navigation.AdvanceNavigationWrapper
import com.aristidevs.nav3example.animation_navigation.AnimationNavigationWrapper
import com.aristidevs.nav3example.basic_navigation.BasicNavigationWrapper
import com.aristidevs.nav3example.medium_navigation.MediumNavigationWrapper
import com.aristidevs.nav3example.ui.theme.Nav3ExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Nav3ExampleTheme {
                AnimationNavigationWrapper()
            }
        }
    }
}