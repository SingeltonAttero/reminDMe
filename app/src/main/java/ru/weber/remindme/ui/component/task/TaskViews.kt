package ru.weber.remindme.ui.component.task

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.weber.remindme.ui.component.task.state.TaskState

@Composable
fun TaskTextItemView(
    state: TaskState.TextItem, modifier: Modifier,
    click: () -> Unit = {}
) {
    val textDecoration = textDecorationFromTaskState(state)
    val color = colorFromTaskStatus(state)
    BaseCardTask(modifier = modifier) {
        Box(
            modifier = Modifier
                .clickable { click.invoke() }
                .padding(16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
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
fun TaskCheckboxItemView(
    state: TaskState.CheckBoxItem,
    modifier: Modifier,
    checked: (Boolean) -> Unit
) {
    val textDecoration = textDecorationFromTaskState(state)
    val color = colorFromTaskStatus(state)
    BaseCardTask(modifier = modifier) {
        Row(
            modifier = Modifier
                .clickable { checked.invoke(!state.isChecked) }
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = state.isChecked, onCheckedChange = {
                checked.invoke(it)
            })
            Box(
                modifier = Modifier.padding(start = 16.dp),
                contentAlignment = Alignment.CenterStart
            ) {
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


