package com.example.persistenciaroom

import android.app.ComponentCaller
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.persistenciaroom.ui.screens.task.TaskScreen
import com.example.persistenciaroom.ui.screens.task.TaskViewModel
import com.example.persistenciaroom.ui.theme.PersistenciaRoomTheme
import kotlinx.coroutines.flow.MutableSharedFlow

class MainActivity : ComponentActivity() {
    private val deepLinks = MutableSharedFlow<Uri>(replay = 1, extraBufferCapacity = 1)
    private val viewModel: TaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //emitDeepLink(intent)
        setContent {
            PersistenciaRoomTheme {
                val state by viewModel.state.collectAsStateWithLifecycle()
                TaskScreen(
                    state = state,
                    onClearClick = {
                        viewModel.clearAll()
                    },
                    onAddClick = { title ->
                        viewModel.addTask(title)
                    },
                    onToggleTask = { task ->
                        viewModel.toggleTask(task)

                    }
                )

            }
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        //emitDeepLink(intent)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PersistenciaRoomTheme {
        Greeting("Android")
    }
}