package ru.weber.remindme.ui.component.task

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.weber.remindme.ui.component.task.state.TaskStateMock
import ru.weber.remindme.ui.theme.RemindMeTheme


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