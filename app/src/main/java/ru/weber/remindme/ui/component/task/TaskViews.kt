package ru.weber.remindme.ui.component.task

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import ru.weber.remindme.ui.component.task.state.TaskState
import ru.weber.remindme.ui.component.task.state.TaskStatus

@Composable
fun TaskTextItemView(
    state: TaskState.TextItem, modifier: Modifier
) {
    val textDecoration = textDecorationFromTaskState(state)
    val style = textStyleFromTaskStatus(state)
    Card(
        modifier = modifier
            .fillMaxWidth(1F)
            .wrapContentHeight()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 2.dp,
        border = if (state.status == TaskStatus.CANCELED) BorderStroke(0.1.dp,MaterialTheme.colors.error) else null
    ) {
        Box(modifier = Modifier.padding(16.dp), contentAlignment = Alignment.CenterStart) {
            Text(
                text = state.title,
                maxLines = 1,
                textDecoration = textDecoration,
                style = style
            )
        }
    }
}

@Composable
private fun textDecorationFromTaskState(state: TaskState.TextItem) =
    when (state.status) {
        TaskStatus.COMPLETE, TaskStatus.CANCELED -> TextDecoration.LineThrough
        TaskStatus.PROCESS -> TextDecoration.None
    }

@Composable
private fun textStyleFromTaskStatus(state: TaskState.TextItem) =
    when (state.status) {
        TaskStatus.COMPLETE, TaskStatus.PROCESS -> MaterialTheme.typography.body1
        TaskStatus.CANCELED -> MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.error)
    }



