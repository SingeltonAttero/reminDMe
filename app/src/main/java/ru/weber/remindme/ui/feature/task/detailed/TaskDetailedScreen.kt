package ru.weber.remindme.ui.feature.task.detailed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.weber.remindme.R
import ru.weber.remindme.ui.component.toolbar.AppToolbar
import ru.weber.remindme.ui.component.toolbar.ToolbarTitle

@Composable
fun TaskDetailedScreen(
    viewModel: TaskDetailedViewModel = hiltViewModel(),
    closeScreen: () -> Unit
) {
    val (text, value) = rememberSaveable {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            AppToolbar(toolbarTitle = ToolbarTitle(R.string.create_new_task, true)) {
                closeScreen.invoke()
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxSize(),
                value = text,
                onValueChange = value::invoke,
                label = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.ThumbUp, contentDescription = "")
                        Text(
                            modifier = Modifier.padding(start = 16.dp),
                            text = "Что нужно сделать?"
                        )
                    }
                })
        }
    }
}