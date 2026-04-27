package com.example.persistenciaroom.ui.screens.task

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.persistenciaroom.data.TaskEntity

@Composable
fun TaskRow(
    task: TaskEntity,
    onToggle: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onToggle() }
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,

        ) {
        Checkbox(
            checked = task.isDone,
            onCheckedChange = { onToggle() }
        )
        Text(
            text = task.title,
            fontSize = 24.sp,
            style =
                if (task.isDone) {
                    MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.outline
                    )
                } else {
                    MaterialTheme.typography.bodyMedium
                }

        )

    }

}