package ru.weber.remindme.ui.component.task

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import ru.weber.remindme.ui.component.task.state.TaskState
import ru.weber.remindme.ui.component.task.state.TaskStatus


@Composable
fun BaseCardTask(
    modifier: Modifier = Modifier,
    composable: @Composable () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth(1F)
            .wrapContentHeight()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 6.dp
    ) {
        composable.invoke()
    }
}

@Composable
fun textDecorationFromTaskState(state: TaskState): TextDecoration =
    when (state.status) {
        TaskStatus.COMPLETE, TaskStatus.CANCELED -> TextDecoration.LineThrough
        TaskStatus.PROCESS -> TextDecoration.None
    }

@Composable
fun colorFromTaskStatus(state: TaskState): Color =
    when (state.status) {
        TaskStatus.COMPLETE, TaskStatus.PROCESS -> MaterialTheme.colors.onSurface
        TaskStatus.CANCELED -> MaterialTheme.colors.error
    }

