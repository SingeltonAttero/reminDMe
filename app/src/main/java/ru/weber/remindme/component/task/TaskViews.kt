package ru.weber.remindme.component.task

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.weber.remindme.Greeting
import ru.weber.remindme.component.task.state.TaskState
import ru.weber.remindme.component.task.state.TaskStateMock
import ru.weber.remindme.component.task.state.TaskStatus
import ru.weber.remindme.ui.theme.RemindMeTheme

@Composable
fun TaskTextItemView(
    state: TaskState.TextItem, modifier: Modifier
) {
    val textDecoration = when (state.status) {
        TaskStatus.COMPLETE, TaskStatus.CANCELED -> TextDecoration.LineThrough
        TaskStatus.PROCESS -> TextDecoration.None
    }

    val style = when (state.status) {
        TaskStatus.COMPLETE, TaskStatus.PROCESS -> MaterialTheme.typography.body1
        TaskStatus.CANCELED -> MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.error)
    }

    Card(
        modifier = modifier
            .fillMaxWidth(1F)
            .wrapContentHeight()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.primary,
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


@Preview(showBackground = true)
@Composable
fun DefaultPreviewLight() {
    RemindMeTheme(false) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TaskStateMock.taskTextMock.forEach {
                TaskTextItemView(state = it, Modifier)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewDark() {
    RemindMeTheme(true) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TaskStateMock.taskTextMock.forEach {
                TaskTextItemView(state = it, Modifier)
            }
        }
    }
}

