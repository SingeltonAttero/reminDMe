package ru.weber.remindme.ui.component.task

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.weber.remindme.ui.component.task.state.TaskState

@Composable
fun TaskTextItemView(
    state: TaskState.TextItem, modifier: Modifier
) {
    val textDecoration = textDecorationFromTaskState(state)
    val color = colorFromTaskStatus(state)
    BaseCardTask(modifier = modifier) {
        Box(modifier = Modifier.padding(16.dp), contentAlignment = Alignment.CenterStart) {
            Text(
                text = state.title,
                maxLines = 1,
                color = color,
                textDecoration = textDecoration,
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Composable
fun TaskCheckboxItemView(state: TaskState.CheckBoxItem, modifier: Modifier) {
    val textDecoration = textDecorationFromTaskState(state)
    val color = colorFromTaskStatus(state)
    BaseCardTask(modifier = modifier) {
        Row(Modifier.padding(16.dp)) {
            Box(contentAlignment = Alignment.CenterStart) {
                Text(
                    text = state.title,
                    maxLines = 1,
                    textDecoration = textDecoration,
                    color = color,
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}


