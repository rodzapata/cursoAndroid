package com.example.todoapp.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todoapp.R
import com.example.todoapp.data.model.Task
import com.example.todoapp.navigation.NavigationDestination
import com.example.todoapp.ui.screens.TodoAppBar
import com.example.todoapp.ui.AppViewModelProvider

object ListDestination : NavigationDestination {
    override val route = "list"
    override val titleRes = R.string.app_name
}

/**
 * Entry route for List screen (Home)
 */
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory),
    navigateToAddTask: () -> Unit
) {

    val homeUiState by viewModel.homeUiState.collectAsState()

    Scaffold(
        topBar = {
            TodoAppBar(
                title = stringResource(id = ListDestination.titleRes)
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToAddTask,
                modifier = Modifier.padding(20.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(id = R.string.task_entry_title)
                )
            }
        }
    ) { innerPadding ->
        ListBody(
            tasksList = homeUiState.tasksList,
            onCheckedChange = { task, isChecked ->
                viewModel.updateTask(task.copy(isDone = isChecked))
            },
            onDeleteClick = {
                viewModel.deleteTask(it)
            },
            contentPadding = innerPadding,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun ListBody(
    modifier: Modifier = Modifier,
    tasksList: List<Task>,
    onCheckedChange: (Task, Boolean) -> Unit,
    onDeleteClick: (Task) -> Unit,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        if (tasksList.isEmpty()) {
            Text(
                text = stringResource(id = R.string.no_tasks_description),
                style = typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(contentPadding)
            )
        } else {
            TodoList(
                tasks = tasksList,
                onCheckedChange = onCheckedChange,
                onDeleteClick = onDeleteClick,
                contentPadding = contentPadding
            )
        }
    }
}

@Composable
fun TodoList(
    tasks: List<Task>,
    onCheckedChange: (Task, Boolean) -> Unit,
    onDeleteClick: (Task) -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = contentPadding
    ) {
        items(tasks, key = { it.id }) { task ->
            TodoCardItem(
                task = task,
                onCheckedChange = { isChecked ->
                    onCheckedChange(task, isChecked)
                },
                onDeleteClick = { onDeleteClick(task) }
            )
        }
    }
}

@Composable
fun TodoCardItem(
    task: Task,
    onCheckedChange: (Boolean) -> Unit,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (task.isDone) Color(0xFFF0F0F0) else colorScheme.surfaceVariant
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = task.isDone,
                onCheckedChange = onCheckedChange
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = task.title,
                    style = typography.titleMedium,
                    textDecoration = if (task.isDone) TextDecoration.LineThrough else TextDecoration.None
                )
                if (task.description.isNotBlank()) {
                    Text(
                        text = task.description,
                        style = typography.bodyMedium,
                        color = colorScheme.onSurfaceVariant,
                        modifier = Modifier.alpha(0.8f)
                    )
                }
            }

            IconButton(onClick = onDeleteClick) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = stringResource(id = R.string.delete_button),
                    tint = colorScheme.error
                )
            }
        }
    }
}